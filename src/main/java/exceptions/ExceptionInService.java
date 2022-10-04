package exceptions;

public class ExceptionInService extends RuntimeException{
    public ExceptionInService(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionInService(String message) {
        super(message);
    }
}
