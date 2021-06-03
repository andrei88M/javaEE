package by.it;

import by.it.entity.Address;
import by.it.entity.People;
import by.it.util.HibernateUtil;
import by.it.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        People people = People.builder()
                .id(null)
                .name("andrey")
                .surname("mih")
                .age(10)
                .build();
        Address address = Address.builder()
                .id(null)
                .house(11)
                .street("aaa")
                .build();
        Session session = new SessionUtil().getSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.persist(people);
        session.persist(address);
        transaction.commit();
        session.close();
    }
}
