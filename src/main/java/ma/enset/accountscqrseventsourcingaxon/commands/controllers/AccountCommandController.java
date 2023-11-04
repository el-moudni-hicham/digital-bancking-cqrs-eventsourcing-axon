package ma.enset.accountscqrseventsourcingaxon.commands.controllers;

import lombok.AllArgsConstructor;
import ma.enset.accountscqrseventsourcingaxon.commonapi.commands.CreateAccountCommand;
import ma.enset.accountscqrseventsourcingaxon.commonapi.commands.CreditAccountCommand;
import ma.enset.accountscqrseventsourcingaxon.commonapi.commands.DebitAccountCommand;
import ma.enset.accountscqrseventsourcingaxon.commonapi.dtos.CreateAccoutRequestDTO;
import ma.enset.accountscqrseventsourcingaxon.commonapi.dtos.CreditAccoutRequestDTO;
import ma.enset.accountscqrseventsourcingaxon.commonapi.dtos.DebitAccoutRequestDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/account")
@AllArgsConstructor
public class AccountCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;
    @PostMapping("/create")
    public CompletableFuture<String> createAccount(@RequestBody CreateAccoutRequestDTO request){
        CompletableFuture<String> commandResponse = commandGateway.send(new CreateAccountCommand(
                UUID.randomUUID().toString(),
                request.getInitialBalance(),
                request.getCurrency()
        ));
        return commandResponse;
    }

    @PostMapping("/debit")
    public CompletableFuture<String> debitAccount(@RequestBody DebitAccoutRequestDTO request){
        return commandGateway.send(new DebitAccountCommand(
                request.getAccountId(),
                request.getAmount(),
                request.getCurrency()
        ));
    }

    @PostMapping("/credit")
    public CompletableFuture<String> creditAccount(@RequestBody CreditAccoutRequestDTO request){
        return commandGateway.send(new CreditAccountCommand(
                request.getAccountId(),
                request.getAmount(),
                request.getCurrency()
        ));
    }

    @GetMapping("/eventStore/{id}")
    public Stream eventStore(@PathVariable String id){
        return eventStore.readEvents(id).asStream();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
