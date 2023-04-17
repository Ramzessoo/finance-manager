package pl.sda.ramzessoo.finanseMenager;

import java.io.InputStream;
import java.sql.Connection;

public class DBInitializer {

    private final Connection connection;
    public DBInitializer(Connection connection) {
        this.connection = connection;
    }

    public void inidDB(){
        try (InputStream expenses = getClass().getResourceAsStream("");)
    }
}
