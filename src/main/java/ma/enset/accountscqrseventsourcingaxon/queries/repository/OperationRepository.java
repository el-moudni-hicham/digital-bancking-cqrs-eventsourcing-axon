package ma.enset.accountscqrseventsourcingaxon.queries.repository;

import ma.enset.accountscqrseventsourcingaxon.queries.entites.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
