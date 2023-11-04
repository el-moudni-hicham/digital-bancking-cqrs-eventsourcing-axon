package ma.enset.accountscqrseventsourcingaxon.commands.aggregates;

import ma.enset.accountscqrseventsourcingaxon.commonapi.commands.CreateAccountCommand;
import ma.enset.accountscqrseventsourcingaxon.commonapi.commands.CreditAccountCommand;
import ma.enset.accountscqrseventsourcingaxon.commonapi.commands.DebitAccountCommand;
import ma.enset.accountscqrseventsourcingaxon.commonapi.enums.AccountStatus;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountCreatedEvent;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountCreditedEvent;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountDebitedEvent;
import ma.enset.accountscqrseventsourcingaxon.commonapi.exceptions.InsufficientBalanceException;
import ma.enset.accountscqrseventsourcingaxon.commonapi.exceptions.NegativeAmountException;
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

    @CommandHandler
    public void handler(DebitAccountCommand command){
        if (command.getAmount() < 0) throw new NegativeAmountException("Negative Amount");
        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()
        ));
    }
    @EventSourcingHandler
    public void on(AccountDebitedEvent event){
        this.balance += event.getAmount();
    }

    @CommandHandler
    public void handler(CreditAccountCommand command){
        if (command.getAmount() < 0) throw new NegativeAmountException("Negative Amount");
        if (command.getAmount() > this.balance) throw new InsufficientBalanceException("Insufficient Balance");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()
        ));
    }
    @EventSourcingHandler
    public void on(AccountCreditedEvent event){
        this.balance -= event.getAmount();
    }
}
