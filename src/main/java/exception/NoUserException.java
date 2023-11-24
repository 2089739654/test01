package exception;

public class NoUserException extends UserException{

    public NoUserException() {
        super();
    }

    public NoUserException(String message) {
        super(message);
    }
}
