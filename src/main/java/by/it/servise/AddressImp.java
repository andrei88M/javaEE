package by.it.servise;

import by.it.model.Address;
import by.it.util.HibernateUtil;
import by.it.util.SessionUtil;
import org.hibernate.Session;

public class AddressImp implements AddressDAO{
    @Override
    public void save(Address address) {
        SessionUtil sessionUtil = new SessionUtil();
        Session session = sessionUtil.getSession();
        session.getTransaction().begin();
        session.save(address);
        session.getTransaction().commit();
    }

    @Override
    public Address get(Integer id) {
        SessionUtil sessionUtil = new SessionUtil();
        Session session = sessionUtil.getSession();
        session.getTransaction().begin();
        Address address = session.get(Address.class, id);
        session.getTransaction().commit();
        sessionUtil.stopSessionFactory();
        return address;
    }

    @Override
    public void update(Address address) {
        SessionUtil sessionUtil = new SessionUtil();
        Session session = sessionUtil.getSession();
        session.getTransaction().begin();
        session.update(address);
        session.getTransaction().commit();
        sessionUtil.stopSessionFactory();
    }

    @Override
    public void delete(Address address) {
        SessionUtil sessionUtil = new SessionUtil();
        Session session = sessionUtil.getSession();
        session.getTransaction().begin();
        session.delete(address);
        session.getTransaction().commit();
        sessionUtil.stopSessionFactory();
    }
}
