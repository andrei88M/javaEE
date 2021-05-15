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
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call savePeople(?,?,?)}");
            callableStatement.setString("inName", people.getName());
            callableStatement.setString("inSurname", people.getSurname());
            callableStatement.setInt("inAge", people.getAge());
            callableStatement.executeUpdate();
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
            callableStatement = connection.prepareCall("{call updatePeople(?,?,?,?)}");
            callableStatement.setInt("inId", people.getId());
            callableStatement.setString("inName", people.getName());
            callableStatement.setString("inSurname", people.getSurname());
            callableStatement.setInt("inAge", people.getAge());
            callableStatement.executeUpdate();
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
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call daletePeople(?)}");
            callableStatement.setInt("inId", people.getId());
            callableStatement.executeUpdate();
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
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call getPeople(?)}");
            callableStatement.setInt("inId", id);
            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                people = People.builder()
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .id(resultSet.getInt("id"))
                        .age(resultSet.getInt("age"))
                        .build();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (callableStatement!=null){
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return people;
    }
}
