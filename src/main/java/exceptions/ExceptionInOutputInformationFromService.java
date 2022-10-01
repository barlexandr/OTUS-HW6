package exceptions;

public class ExceptionInOutputInformationFromService extends RuntimeException{
    public ExceptionInOutputInformationFromService(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionInOutputInformationFromService(String message) {
        super(message);
    }
}
