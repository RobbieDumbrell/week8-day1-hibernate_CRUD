package db;

import models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCustomer {

    private static Session session;
    private static Transaction transaction;

    public static void save(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        } catch(HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Customer> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> allCustomers = null;
        try {
            Criteria cr = session.createCriteria(Customer.class);
            allCustomers = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return allCustomers;
    }

    public static Customer findById(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Customer foundCustomer = null;
        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.add(Restrictions.eq("id", id));
            foundCustomer = (Customer) cr.uniqueResult();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return foundCustomer;
    }

    public static void update(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch(HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        } catch(HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
