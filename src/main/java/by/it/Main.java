package by.it;

import by.it.entity.Address;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        Address address = new Address();
        address.setId(null);
               address.setHouse(11);
               address.setStreet("hghg");
       EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
