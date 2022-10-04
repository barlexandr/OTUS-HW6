package domain;

import java.io.IOException;

public class Connection implements AutoCloseable {
    public Connection() {
    }

    public void open() throws IOException {
        throw new IOException("Exception in " + this.getClass());
    }

    @Override
    public void close() {
        System.out.println(this.getClass() + " was closed.");
    }
}
