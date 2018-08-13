package db;

import models.Order;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBOrder {

    private static Session session;
    private static Transaction transaction;

    public static void save(Order order){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch(HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Order> getAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Order> allOrders = null;
        try {
            Criteria cr = session.createCriteria(Order.class);
            allOrders = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return allOrders;
    }

    public static Order findById(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Order foundOrder = null;
        try {
            Criteria cr = session.createCriteria(Order.class);
            cr.add(Restrictions.eq("id", id));
            foundOrder = (Order) cr.uniqueResult();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return foundOrder;
    }

    public static void update(Order order){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch(HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Order order){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(order);
            transaction.commit();
        } catch(HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
