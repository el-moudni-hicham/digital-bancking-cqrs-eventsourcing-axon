package ma.enset.accountscqrseventsourcingaxon.commonapi.exceptions;

public class NegativeInitialBalanceException extends RuntimeException {
    public NegativeInitialBalanceException(String msg) {
        super(msg);
    }
}
