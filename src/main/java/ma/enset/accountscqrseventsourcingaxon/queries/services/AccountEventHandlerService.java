package ma.enset.accountscqrseventsourcingaxon.queries.services;

import lombok.extern.slf4j.Slf4j;
import ma.enset.accountscqrseventsourcingaxon.commonapi.enums.TransactionType;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountCreatedEvent;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountCreditedEvent;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountDebitedEvent;
import ma.enset.accountscqrseventsourcingaxon.queries.entites.Account;
import ma.enset.accountscqrseventsourcingaxon.queries.entites.Operation;
import ma.enset.accountscqrseventsourcingaxon.queries.query.GetAccountQuery;
import ma.enset.accountscqrseventsourcingaxon.queries.query.GetAllAccountsQuery;
import ma.enset.accountscqrseventsourcingaxon.queries.repository.AccountRepository;
import ma.enset.accountscqrseventsourcingaxon.queries.repository.OperationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class AccountEventHandlerService {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    public AccountEventHandlerService(AccountRepository accountRepository, OperationRepository operationRepository) {
        this.accountRepository = accountRepository;
        this.operationRepository = operationRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent event, EventMessage<AccountCreatedEvent> eventMessage){
        log.info("__________________ log ___________________");
        log.info("Account Created Event Recived");
        Account account = Account.builder()
                .id(event.getId())
                .CreatedAt(eventMessage.getTimestamp())
                .balance(event.getBalance())
                .currency(event.getCurrency())
                .status(eventMessage.getPayload().getStatus())
                .build();

        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountDebitedEvent event, EventMessage<AccountDebitedEvent> eventMessage){
        log.info("__________________ log ___________________");
        log.info("Account Debited Event Recived");
        Account account = accountRepository.findById(event.getId()).get();
        account.setBalance(account.getBalance() - event.getAmount());
        accountRepository.save(account);

        Operation operation = Operation.builder()
                .account(account)
                .amount(event.getAmount())
                .type(TransactionType.DEBIT)
                .timestamp(eventMessage.getTimestamp())
                .build();
        operationRepository.save(operation);
    }

    @EventHandler
    public void on(AccountCreditedEvent event, EventMessage<AccountCreditedEvent> eventMessage){
        log.info("__________________ log ___________________");
        log.info("Account Credited Event Recived");
        Account account = accountRepository.findById(event.getId()).get();
        account.setBalance(account.getBalance() + event.getAmount());
        accountRepository.save(account);

        Operation operation = Operation.builder()
                .account(account)
                .amount(event.getAmount())
                .type(TransactionType.CREDIT)
                .timestamp(eventMessage.getTimestamp())
                .build();
        operationRepository.save(operation);
    }

    @QueryHandler
    public List<Account> on(GetAllAccountsQuery query){
        return accountRepository.findAll();
    }

    @QueryHandler
    public Account on(GetAccountQuery query){
        return accountRepository.findById(query.getId()).get();
    }
}
