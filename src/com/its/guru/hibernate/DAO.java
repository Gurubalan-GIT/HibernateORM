package com.its.guru.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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
        }catch (HibernateException e){
            System.out.println(e.getMessage());
            System.out.print("Error!");
        }
    }
}
