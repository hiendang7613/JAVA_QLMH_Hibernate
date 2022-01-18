package DAO;

import pojo.*;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import GUI.Menu_GUI;

import org.hibernate.SessionFactory;

public class AccountDAO {

	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static List<Account> getList() {
		List<Account> l = null;
		Session s = factory.openSession();

		try {

			String hql = "SELECT st FROM Account st";
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
	public static void Add(Account account) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(account);
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
	public static void Update(Account account) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(account);
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
	public static void Delete(String username) {

		Session session = factory.openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();
			
			Account x = (Account) session.get(Account.class, username);
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

	public static List<Account> Find(Account account) {
		Session session = factory.openSession();
        Transaction transaction = null;
        
        try {
        	
            transaction = session.beginTransaction();
            
            String condition ="";
            if(!account.getUsername().isEmpty()) {
            	condition += "username = '" +account.getUsername()+"' and ";
            }
            if(!account.getPassword().isEmpty()) {
            	condition += "password = '" + account.getPassword()+"' and ";
            }
            
            condition = condition.substring(0,condition.length()-5);
            
            Query query = session.createQuery("from Account where " + condition );
            List<Account> result = query.list();
            
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
