package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class ConnectionDB {
    private String url = "jdbc:mysql://localhost:3306/hw";
    private String user = "root";
    private String password = "54321";

    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
