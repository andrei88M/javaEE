package dao;

import entity.Address;
import entity.AddressPeople;
import entity.People;

public interface AddressPeopleDAO extends DAO<AddressPeople>{
    AddressPeople get(int address_id, int people_id);
}
