package util;

import java.sql.SQLException;
import java.sql.Savepoint;

public class Creator extends ConnectionDB {
    public void dropAndCreateTable() {
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.addBatch("CREATE TABLE if not exists address(" +
                    "        id      int auto_increment," +
                    "        street  varchar(50)," +
                    "        house   int," +
                    "        primary key (id)" +
                    "    )");
            statement.addBatch("CREATE TABLE if not exists people(" +
                    "        id      int auto_increment," +
                    "        name    varchar(50)," +
                    "        surname varchar(50)," +
                    "        age     int," +
                    "        primary key (id)" +
                    "    )");
            statement.executeBatch();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void dropAndCreateTable2() {
        Savepoint savepoint = null;
        try {
            dropTable();
            createTable();
            connection = getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            statement.executeUpdate("insert into people(age) values (11)");
            savepoint = connection.setSavepoint();
            statement.executeUpdate("insert into address(age) values (11)");
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback(savepoint);
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void createTable() {
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call createTable()}");
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public void dropTable() {
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call dropTable}");
            callableStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
