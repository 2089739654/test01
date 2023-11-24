package exception;

public class ClientException extends Exception{
    public ClientException() {
        super();
    }

    public ClientException(String message) {
        super(message);
    }
}
