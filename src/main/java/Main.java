import dao.AddressDAO;
import dao.AddressImpl;
import dao.PeopleDAO;
import dao.PeopleImpl;
import entity.Address;
import entity.People;
import util.Creator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.createDB();
        creator.createTable();

        AddressDAO addressDAO = new AddressImpl();
        PeopleDAO peopleDAO = new PeopleImpl();
        for (int i = 1; i <=5 ; i++) {
            Address address = Address.builder()
                    .street("street" + i)
                    .house(i+i)
                    .build();
            addressDAO.save(address);
            People people = People.builder()
                    .age(i+i+i)
                    .name("name" + i)
                    .surname("surname" + i)
                    .build();
            peopleDAO.save(people);
        }
        List<Address> addressList = addressDAO.getAll();
        List<People> peopleList = peopleDAO.getAll();

        Address address = addressDAO.getAddress(addressList.size()-1);
        address.setHouse(address.getHouse()+1);
        addressDAO.update(address);
        address = addressDAO.getAddress(addressList.size()-2);
        address.setHouse(address.getHouse()+1);
        addressDAO.update(address);

        People people = peopleDAO.getPeople(peopleList.size()-1);
        people.setAge(people.getAge()+2);
        peopleDAO.update(people);
        people = peopleDAO.getPeople(peopleList.size()-2);
        people.setAge(people.getAge()+2);
        peopleDAO.update(people);

        peopleDAO.delete(peopleList.get(1));
        addressDAO.delete(addressList.get(1));

        System.out.println(addressDAO.getAll());
        System.out.println(peopleDAO.getAll());
    }
}
