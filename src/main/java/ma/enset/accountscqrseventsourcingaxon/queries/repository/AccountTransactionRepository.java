package ma.enset.accountscqrseventsourcingaxon.queries.repository;

import ma.enset.accountscqrseventsourcingaxon.queries.entites.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {
}
