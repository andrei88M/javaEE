package dao;

import entity.Address;
import util.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressImpl extends ConnectionDB implements AddressDAO {
    @Override
    public Address get(int id) {
        Address address = null;
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call getAddress(?)}");
            callableStatement.setInt(1, id);
            resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                address = Address.builder()
                        .id(resultSet.getInt("id"))
                        .street(resultSet.getString("street"))
                        .house(resultSet.getInt("house"))
                        .build();
            }
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return address;
    }

    @Override
    public void save(Address address) {
        String sql = "INSERT INTO address(street,house) VALUES (?,?)";
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call saveAddress(?,?)}");
            callableStatement.setString(1, address.getStreet());
            callableStatement.setInt(2, address.getHouse());
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
            if (callableStatement != null) {
                try {
                    callableStatement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Address> getAll() {
        List<Address> list = new ArrayList<>();
        String sql = "SELECT * FROM address";
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Address address = Address.builder()
                        .id(resultSet.getInt("id"))
                        .street(resultSet.getString("street"))
                        .house(resultSet.getInt("house"))
                        .build();
                list.add(address);
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
    public void update(Address address) {
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call updateAddress(?,?,?)}");
            callableStatement.setInt("inId", address.getId());
            callableStatement.setString("inStreet", address.getStreet());
            callableStatement.setInt("inHouse", address.getHouse());
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

    @Override
    public void delete(Address address) {
        String sql = "DELETE FROM address WHERE id=?";
        try {
            connection = getConnection();
            callableStatement = connection.prepareCall("{call deleteAddress(?)}");
            callableStatement.setInt(1,address.getId());
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
}
