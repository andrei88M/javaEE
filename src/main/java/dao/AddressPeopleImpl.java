package dao;

import entity.AddressPeople;
import util.ConnectionDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AddressPeopleImpl extends ConnectionDB implements AddressPeopleDAO {
    @Override
    public AddressPeople get(int address_id, int people_id) {
        AddressPeople ap = null;
        String sql = "SELECT * FROM address_people WHERE address_id=?,people_id=?";
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, address_id);
            preparedStatement.setInt(2, people_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ap = AddressPeople.builder()
                        .address_id(resultSet.getInt("address_id"))
                        .people_id(resultSet.getInt("people_id"))
                        .build();
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
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
        return ap;
    }

    @Override
    public void save(AddressPeople address_people) {
        String sql = "INSERT INTO address_people(address_id,people_id) VALUES (?,?)";
        try {
            connection=getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,address_people.getAddress_id());
            preparedStatement.setInt(2,address_people.getPeople_id());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
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
    }

    @Override
    public List<AddressPeople> getAll() {
        return null;
    }

    @Override
    public void update(AddressPeople address_people) {

    }

    @Override
    public void delete(AddressPeople address_people) {

    }
}
