package ma.enset.accountscqrseventsourcingaxon.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class CreditAccoutRequestDTO {
    private String accountId;
    private double amount;
    private String currency;
}
