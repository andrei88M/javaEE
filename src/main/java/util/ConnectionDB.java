package util;

import java.sql.*;

public abstract class ConnectionDB {
    private String url = "jdbc:mysql://localhost:3306/hw";
    private String user = "root";
    private String password = "54321";

    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected CallableStatement callableStatement = null;
    protected ResultSet resultSet = null;
    protected Statement statement= null;

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
