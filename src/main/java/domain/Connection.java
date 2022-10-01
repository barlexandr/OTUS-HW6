package domain;

import java.io.IOException;

public class Connection implements AutoCloseable {
    public Connection() throws IOException {
        throw new IOException("Exception in " + this.getClass());
    }

    @Override
    public void close() {
    }
}
