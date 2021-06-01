package by.it;

import by.it.entity.Address;
import by.it.entity.People;
import by.it.util.HibernateUtil;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        Address address = Address.builder()
                .id(null)
                .house(11)
                .street("horeckogo")
                .build();
        Address address2 = Address.builder()
                .id(null)
                .house(101)
                .street("horeckogo2")
                .build();
        People people = People.builder()
                .id(null)
                .age(23)
                .name("andrey")
                .surname("mikhalchuk")
                .build();
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.persist(address2);
        entityManager.persist(people);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
