package DAO;

import pojo.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.hibernate.SessionFactory;

public class SubjectDAO {

	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static List<Subject> getList() {
		List<Subject> l = null;		
		Session s = factory.openSession();

		try {

			String hql = "FROM Subject";
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
	public static void Add(Subject subject) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {
			
			tx = session.beginTransaction();
			session.save(subject);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Method to UPDATE
	public static void Update(Subject subject) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try {
	    	
	    	tx = session.beginTransaction();
	    	session.update(subject);
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
            Subject x = (Subject) session.get(Subject.class, iD);
            session.delete(x);
            transaction.commit();
            
        } catch (HibernateException e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    public static List<Subject> Find(Subject subject) {
		Session session = factory.openSession();
        Transaction transaction = null;
        
        try {
        	
            transaction = session.beginTransaction();
            
            String condition ="";
            if(!subject.getiD().isEmpty()) {
            	condition += "id = '" +subject.getiD()+"' and ";
            }
            if(!subject.getName().isEmpty()) {
            	condition += "name = '" + subject.getName()+"' and ";
            }
            
            condition = condition.substring(0,condition.length()-5);
            
            Query query = session.createQuery("from Subject where " + condition );
            List<Subject> result = query.list();
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
