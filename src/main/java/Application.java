import domain.Connection;
import domain.Server;
import exceptions.ExceptionInConnection;
import exceptions.ExceptionInOutputInformationFromService;
import exceptions.ExceptionInService;

import java.io.IOException;

import static utils.Constants.MAX_DELAY;
import static utils.Constants.TIMEOUT_BETWEEN_CONNECT;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.tryWithResourceOutputException();
        System.out.println();
        application.tryWithResourceRethrowException();
        System.out.println();
        application.tryWithResourceExceptionRetry();
    }

    public void tryWithResourceOutputException() {
        try (Connection connection = new Connection()) {
            System.out.println("Work");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public void tryWithResourceRethrowException() {
        try {
            try {
                try (Connection connection = new Connection()) {
                    System.out.println("Work");
                } catch (Exception e) {
                    throw new ExceptionInConnection("exception in connection");
                }
            } catch (Exception e) {
                throw new ExceptionInService("exception in service", e);
            }
        } catch (Exception e) {
            throw new ExceptionInOutputInformationFromService("exception in output info from service", e);
        }
    }

    public void tryWithResourceExceptionRetry() {
        Server server = new Server();
        for (int i = 0; i < MAX_DELAY; i++) {
            try {
                server.setConnection(new Connection());
                System.out.println("domain.Connection is enabled");
                break;
            } catch (IOException e) {
                System.out.println("domain.Connection number " + i + " : " + e.getMessage());
            }
            try {
                Thread.sleep(TIMEOUT_BETWEEN_CONNECT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (server.getConnection() == null) {
            throw new RuntimeException("domain.Connection to server was failed!");
        }
    }

}
