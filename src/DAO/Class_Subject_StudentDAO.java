package DAO;

import pojo.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

public class Class_Subject_StudentDAO {

	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static List<Class_Subject_Student> getList() {
		List<Class_Subject_Student> l = null;
		Session s = factory.openSession();

		try {

			String hql = "SELECT st FROM Class_Subject_Student st";
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
	public static void Add(Class_Subject_Student x) {
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
	public static void Update(Class_Subject_Student x) {
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
	public static void Delete(String classID, String subjectID, String studentID) {

		Session session = factory.openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			Query query = session.createQuery("from Class_Subject_Student where StudentID = '" + studentID + "' and SubjectID = '" + subjectID + "' and ClassID = '" + classID+"'");
			List<Class_Subject_Student> x = query.list();
			session.delete(x.get(0));
			transaction.commit();

		} catch (HibernateException e) {
			if (transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	// Method to find
	public static List<Class_Subject_Student> Find(Class_Subject_Student x) {

		Session session = factory.openSession();
		Transaction transaction = null;

		try {

			transaction = session.beginTransaction();

			String condition = "";
			if (!x.getStudentID().isEmpty()) {
				condition += "studentID = '" + x.getStudentID() + "' and ";
			}
			if (!x.getSubjectID().isEmpty()) {
				condition += "subjectID = '" + x.getSubjectID() + "' and ";
			}
			if (!x.getClassID().isEmpty()) {
				condition += "classID = '" + x.getClassID() + "' and ";
			}

			condition = condition.substring(0, condition.length() - 5);

			Query query = session.createQuery("from Class_Subject_Student where " + condition);
			List<Class_Subject_Student> result = query.list();
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
