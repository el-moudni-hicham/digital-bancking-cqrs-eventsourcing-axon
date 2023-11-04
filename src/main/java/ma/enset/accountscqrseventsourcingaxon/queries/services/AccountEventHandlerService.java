package ma.enset.accountscqrseventsourcingaxon.queries.services;

import lombok.extern.slf4j.Slf4j;
import ma.enset.accountscqrseventsourcingaxon.commonapi.events.AccountCreatedEvent;
import ma.enset.accountscqrseventsourcingaxon.queries.entites.Account;
import ma.enset.accountscqrseventsourcingaxon.queries.repository.AccountRepository;
import ma.enset.accountscqrseventsourcingaxon.queries.repository.AccountTransactionRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class AccountEventHandlerService {
    private AccountRepository accountRepository;
    private AccountTransactionRepository accountTransactionRepository;

    public AccountEventHandlerService(AccountRepository accountRepository, AccountTransactionRepository accountTransactionRepository) {
        this.accountRepository = accountRepository;
        this.accountTransactionRepository = accountTransactionRepository;
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
}
