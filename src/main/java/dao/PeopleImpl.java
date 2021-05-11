package dao;

import entity.People;
import util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PeopleImpl extends ConnectionDB implements PeopleDAO {
    @Override
    public void save(People people) {
        String sql = "INSERT INTO people(name,surname,age) VALUES (?,?,?)";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3, people.getAge());
            preparedStatement.setString(2, people.getSurname());
            preparedStatement.setString(1, people.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<People> getAll() {
        List<People> list = new ArrayList<>();
        String sql = "SELECT * FROM people";
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                People people = People.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .age(resultSet.getInt("age"))
                        .build();
                list.add(people);
            }
            resultSet.close();
            statement.close();
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
        }
        return list;
    }

    @Override
    public void update(People people) {
        String sql = "UPDATE people SET name =?,surname=?,age=? WHERE id=?";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, people.getName());
            preparedStatement.setString(2, people.getSurname());
            preparedStatement.setInt(3, people.getAge());
            preparedStatement.setInt(4,people.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(People people) {
        String sql = "DELETE FROM people WHERE id=?";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, people.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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

    @Override
    public People get(int id) {
        People people = null;
        String sql = "SELECT * FROM people WHERE id=?";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                people = People.builder()
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .id(resultSet.getInt("id"))
                        .age(resultSet.getInt("age"))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }
}
