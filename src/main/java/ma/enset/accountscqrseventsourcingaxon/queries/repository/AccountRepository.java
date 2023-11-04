package ma.enset.accountscqrseventsourcingaxon.queries.repository;

import ma.enset.accountscqrseventsourcingaxon.queries.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
