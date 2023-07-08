package by.tms.springstore.exceptions;

public class InvalidUserPasswordException extends RuntimeException {
    public InvalidUserPasswordException(String message) {
        super(message);
    }
}
