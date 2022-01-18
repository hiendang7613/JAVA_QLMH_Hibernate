package DAO;

import pojo.*;
import pojo.Class;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.hibernate.SessionFactory;

public class ClassDAO {

	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static List<Class> getList() {
		List<Class> l = null;
		Session s = factory.openSession();

		try {

			String hql = "FROM Class";
			Query q = s.createQuery(hql);
			l = q.list();

		} catch (HibernateException ex) {
			System.err.println(ex);
		} finally {
			s.close();
		}
		return l;
	}

	// Method Add
	public static void Add(String iD) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			Class x = new Class(iD);
			session.save(x);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Method to DELETE an employee from the records
    public static void Delete(String iD) {
    	
        Session session = factory.openSession();
        Transaction transaction = null;
        
        try {
        	
            transaction = session.beginTransaction();
            Class student = (Class) session.get(Class.class, iD);
            session.delete(student);
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public static List<Class> Find(String iD) {
		Session session = factory.openSession();
        Transaction transaction = null;
        
        try {
        	
            transaction = session.beginTransaction();
            
            Query query = session.createQuery("from Class where id = '" + iD +"'" );
            List<Class> result = query.list();
            transaction.commit();
            return result;
            
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		return null;
	}
    
}
