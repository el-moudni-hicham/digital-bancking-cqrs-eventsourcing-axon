package ma.enset.accountscqrseventsourcingaxon.queries.controllers;

import ma.enset.accountscqrseventsourcingaxon.queries.entites.Account;
import ma.enset.accountscqrseventsourcingaxon.queries.query.GetAccountQuery;
import ma.enset.accountscqrseventsourcingaxon.queries.query.GetAllAccountsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/query/account")
public class AccountQueryController {
    private QueryGateway queryGateway;

    public AccountQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping("/accounts")
    public List<Account> accounts(){
        return queryGateway.query(new GetAllAccountsQuery(), ResponseTypes.multipleInstancesOf(Account.class)).join();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable String id){
        return queryGateway.query(new GetAccountQuery(id), ResponseTypes.instanceOf(Account.class)).join();
    }
}
