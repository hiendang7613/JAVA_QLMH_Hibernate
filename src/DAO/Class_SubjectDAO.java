package DAO;

import pojo.*;
import pojo.Class;

import java.awt.Frame;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.hibernate.SessionFactory;

public class Class_SubjectDAO {

	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static List<Class_Subject> getList() {
		List<Class_Subject> l = null;
		Session s = factory.openSession();

		try {

			String hql = "FROM Class_Subject";
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
	public static void Add(Class_Subject x) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
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

	// Method to UPDATE
	public static void Update(Class_Subject x) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			session.update(x);
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
	public static void Delete(String classID, String subjectID) {

		Session session = factory.openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

				Query query = session.createQuery(
					"from Class_Subject where classID = '" + classID + "' and subjectID = '" + subjectID + "'");
			List<Class> result = query.list();
			session.delete(result.get(0));
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static List<Class_Subject> Find(String classID, String subjectID) {
		Session session = factory.openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			Query query = session.createQuery(
					"from Class_Subject where classID = '" + classID + "' and subjectID = '" + subjectID + "'");
			List<Class_Subject> result = query.list();
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
