package com.its.guru.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Iterator;

//Database operations.
public class DAO {
    public void addUser(String fn,String ln,String un,String pass,String address,String gender) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            EntityClass entityClass = new EntityClass();
            entityClass.setFirstName(fn);
            entityClass.setLastName(ln);
            entityClass.setUsername(un);
            entityClass.setPassword(pass);
            entityClass.setAddress(address);
            entityClass.setGender(gender);
            session.save(entityClass);
            session.getTransaction().commit();
            HibernateUtil.shutdown();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            System.out.print("Error!");
        }
    }
    public void updateUser(int key){
        //Using Hibernate Query Language.
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //Method 1:
        String hql="FROM EntityClass where key="+key;
        Query query=session.createQuery(hql);
        /* Method 2:
        String hql="FROM EntityClass where key=:key";
        Query query=session.createQuery(hql);
        query.setParameter("key",key);
        */
        for(Iterator iterator=query.iterate();iterator.hasNext();){
            EntityClass entityClass=(EntityClass) iterator.next();
            entityClass.setFirstName("Guru");
            session.update(entityClass);
        }
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
