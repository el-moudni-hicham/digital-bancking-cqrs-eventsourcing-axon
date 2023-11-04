package ma.enset.accountscqrseventsourcingaxon.queries.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class GetAccountQuery {
    private String id;
}
