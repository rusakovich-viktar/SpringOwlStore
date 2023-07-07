package by.tms.springstore.exceptions;

public class UserNotFoundByEmailException extends RuntimeException {

    public UserNotFoundByEmailException(String message) {
        super(message);
    }

}
