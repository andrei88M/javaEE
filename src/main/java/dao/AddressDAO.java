package dao;

import entity.Address;

public interface AddressDAO extends DAO<Address> {
    Address getAddress(int id);
}
