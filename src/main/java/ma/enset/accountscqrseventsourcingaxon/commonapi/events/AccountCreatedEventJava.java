package ma.enset.accountscqrseventsourcingaxon.commonapi.events;

import lombok.Getter;
import ma.enset.accountscqrseventsourcingaxon.commonapi.enums.AccountStatus;

public class AccountCreatedEventJava extends BaseEvent<String>{
    @Getter private double balance;
    @Getter private String currency;
    @Getter private AccountStatus status;
    public AccountCreatedEventJava(String id, double balance, String currency, AccountStatus status) {
        super(id);
        this.balance = balance;
        this.currency = currency;
        this.status = status;
    }
}
