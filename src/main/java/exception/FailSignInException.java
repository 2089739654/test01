package exception;

public class FailSignInException extends UserException{
    public FailSignInException() {
        super();
    }

    public FailSignInException(String message) {
        super(message);
    }
}
