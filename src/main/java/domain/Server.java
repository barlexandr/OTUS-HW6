package domain;

public class Server implements AutoCloseable{
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() {
    }
}
