package domain;

import java.io.IOException;

public class Server implements AutoCloseable{
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void start() throws IOException {
        this.connection = null;
        throw new IOException("Exception in " + this.getClass());
    }

    @Override
    public void close() {
    }
}
