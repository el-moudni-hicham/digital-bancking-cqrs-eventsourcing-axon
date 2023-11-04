package ma.enset.accountscqrseventsourcingaxon.commonapi.exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String msg) {
        super(msg);
    }
}
