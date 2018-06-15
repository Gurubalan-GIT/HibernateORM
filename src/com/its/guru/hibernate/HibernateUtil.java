package com.its.guru.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/*This will invoke the hibernate.cfg.xml file and get the properties of drivers and databases.
The Hibernate JARs and Java connector JARs are located in WEB-INF/lib.
*/
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}