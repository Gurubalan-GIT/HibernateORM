package com.its.guru.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Iterator;

//Database operations.
public class DAO {
    //Add a new entry to the database.
    public void addUser(String email,String password) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            EntityClass entityClass = new EntityClass();
            entityClass.setEmail(email);
            entityClass.setPassword(password);
            session.save(entityClass);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            System.out.print("Error!");
        }
    }
    //Update an existing user in the database according to key.
    public void updateUser(int key){
        //Using Hibernate Query Language.
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Method 1:
            String hql = "FROM EntityClass where key=" + key;
            Query query = session.createQuery(hql);
        /* Method 2:
        String hql="FROM EntityClass where key=:key";
        Query query=session.createQuery(hql);
        query.setParameter("key",key);
        */
            for (Iterator iterator = query.iterate(); iterator.hasNext(); ) {
                EntityClass entityClass = (EntityClass) iterator.next();
                //entityClass.setFirstName("Guru");
                session.update(entityClass);
            }
            session.getTransaction().commit();
            HibernateUtil.shutdown();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
    //Delete a particular user with the key.
    public void DeleteUser(int key){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Method 1:
            String hql = "FROM EntityClass where key=" + key;
            Query query = session.createQuery(hql);
        /* Method 2:
        String hql="FROM EntityClass where key=:key";
        Query query=session.createQuery(hql);
        query.setParameter("key",key);
        */
            for (Iterator iterator = query.iterate(); iterator.hasNext(); ) {
                EntityClass entityClass = (EntityClass) iterator.next();
                session.delete(entityClass);
            }
            session.getTransaction().commit();
            HibernateUtil.shutdown();
        }catch (HibernateException e){
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
    }
    //Display User Details on the console.
    public void DisplayUser(){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            //Method 1:
            String hql = "FROM EntityClass";
            Query query = session.createQuery(hql);
            for (Iterator iterator = query.iterate(); iterator.hasNext(); ) {
                EntityClass entityClass = (EntityClass) iterator.next();
                System.out.println(entityClass.getPassword());
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
