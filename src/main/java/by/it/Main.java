package by.it;

import by.it.model.Address;
import by.it.model.Person;
import by.it.servise.AddressDAO;
import by.it.servise.AddressImp;
import by.it.util.HibernateUtil;
import by.it.util.SessionUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Address address = Address.builder().id(null).house(11).street("dsds").build();
        Address address2 = Address.builder().id(null).house(1111).street("dsd1s").build();
        Person person = Person.builder().id(null).age(11).build();

        AddressDAO addressDAO = new AddressImp();
        addressDAO.save(address);
        addressDAO.save(address2);

        address = addressDAO.get(1);
        address.setHouse(22);

        addressDAO.update(address);

        addressDAO.delete(address);

    }
}
