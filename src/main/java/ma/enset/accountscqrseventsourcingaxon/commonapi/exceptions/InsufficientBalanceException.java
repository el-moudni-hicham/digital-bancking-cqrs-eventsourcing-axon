package ma.enset.accountscqrseventsourcingaxon.commonapi.exceptions;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}
