package by.it;

import by.it.util.JPA;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPA.getEntityManager();
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();
        JPA.close();

    }
}
