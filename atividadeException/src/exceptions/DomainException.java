package exceptions;

public class DomainException extends Exception {
    public DomainException() {
    }
    public DomainException(String message) {
        super(message);
    }
}
