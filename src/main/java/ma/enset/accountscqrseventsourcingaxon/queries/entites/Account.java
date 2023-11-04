package ma.enset.accountscqrseventsourcingaxon.queries.entites;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.accountscqrseventsourcingaxon.commonapi.enums.AccountStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Account {
    @Id
    private String id;
    private Instant CreatedAt;
    private double balance;
    private String currency;
    private AccountStatus status;
    @OneToMany(mappedBy = "account")
    private List<AccountTransaction> transactions;

}
