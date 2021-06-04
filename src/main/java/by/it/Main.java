package by.it;

import by.it.model.Address;
import by.it.util.SessionUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        SessionUtil sessionUtil = new SessionUtil();
        Session session = sessionUtil.getSession();
        session.getTransaction().begin();

        Address address = Address.builder().id(null).house(11).build();
        session.persist(address);


        session.getTransaction().commit();
        sessionUtil.stopSessionFactory();
    }
}
