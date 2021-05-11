import dao.AddressDAO;
import dao.AddressImpl;
import dao.PeopleDAO;
import dao.PeopleImpl;
import entity.Address;
import entity.People;
import util.Creator;


public class Main {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.createDB();
        creator.createTableOneToMany();

        People people = People.builder().build();
        People people1 = People.builder().build();
        PeopleDAO peopleDAO = new PeopleImpl();
        peopleDAO.save(people);
        peopleDAO.save(people1);

        Address address = Address.builder()
                .house(11)
                .street("street")
                .people_id(2)
                .build();
        AddressDAO addressDAO = new AddressImpl();
        addressDAO.save(address);


    }
}
