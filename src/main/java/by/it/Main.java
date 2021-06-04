package by.it;

import by.it.model.Address;
import by.it.model.Person;
import by.it.util.SessionUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        SessionUtil sessionUtil = new SessionUtil();
        Session session = sessionUtil.getSession();
        session.getTransaction().begin();

        Address address = Address.builder().id(null).house(11).build();
        session.persist(address);
        Person person = Person.builder().id(null).age(11).build();
        session.persist(person);

        session.getTransaction().commit();
        sessionUtil.stopSessionFactory();
    }
}
