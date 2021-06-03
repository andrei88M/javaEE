package by.it.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
    private SessionFactory sessionFactory;

    public SessionUtil() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void close() {
        sessionFactory.close();
    }

    public static SessionFactory getSession2() {
        try {
            StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                    .configure().build();

            Metadata metadata = new MetadataSources(ssr.getParentServiceRegistry()).getMetadataBuilder().build();

            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable throwable) {
            System.out.println(throwable);
            System.err.println(throwable);
            throw new ExceptionInInitializerError();
        }
    }


}
