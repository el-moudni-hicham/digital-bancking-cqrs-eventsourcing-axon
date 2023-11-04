package ma.enset.accountscqrseventsourcingaxon.commands.aggregates;

import ma.enset.accountscqrseventsourcingaxon.commonapi.commands.CreateAccountCommand;
import ma.enset.accountscqrseventsourcingaxon.commonapi.enums.AccountStatus;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountCreatedEvent;
import ma.enset.accountscqrseventsourcingaxon.commonapi.exceptions.NegativeInitialBalanceException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

// Objet Aggregate represente l'etat actuel de l'application
@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate() {
        //Required by AXON
    }

    @CommandHandler //Search in Command Bus
    public AccountAggregate(CreateAccountCommand command) {
        if (command.getInitialBalance() < 0) throw new NegativeInitialBalanceException("Negative Initial Balance");
        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command.getInitialBalance(),
                command.getCurrency(),
                AccountStatus.CREATED
        ));
    }

    @EventSourcingHandler //Search in Event Store
    public void on(AccountCreatedEvent event){
        this.accountId = event.getId();
        this.balance = event.getBalance();
        this.currency = event.getCurrency();
        this.status = event.getStatus();
    }
}
