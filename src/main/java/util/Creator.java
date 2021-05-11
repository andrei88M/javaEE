package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Creator extends ConnectionDB {
    public void createDB() {
        String createSQL = "CREATE DATABASE hw";
        String dropSQL = "DROP DATABASE if exists hw";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(dropSQL);
            statement.executeUpdate(createSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTable() {
        String address = "CREATE TABLE address(id int auto_increment," +
                "street varchar (50)," +
                "house int ," +
                "primary key (id))";
        String people = "CREATE TABLE people(id int auto_increment primary key ," +
                "name varchar (50)," +
                "surname varchar (50)," +
                "age int)";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(address);
            statement.executeUpdate(people);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTableManyToMany() {
        String address = "CREATE TABLE address(id int auto_increment," +
                "street varchar (50)," +
                "house int ," +
                "primary key (id))";
        String people = "CREATE TABLE people(id int auto_increment primary key ," +
                "name varchar (50)," +
                "surname varchar (50)," +
                "age int)";
        String manyToMany = "CREATE TABLE address_people(" +
                "address_id int ," +
                "people_id int," +
                "primary key (address_id,people_id)," +
                "foreign key (address_id) references address(id)," +
                "foreign key (people_id) references people(id))";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(address);
            statement.executeUpdate(people);
            statement.executeUpdate(manyToMany);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
