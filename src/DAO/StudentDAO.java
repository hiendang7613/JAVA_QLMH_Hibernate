package DAO;

import pojo.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import org.hibernate.SessionFactory;

public class StudentDAO {

	private static SessionFactory factory = HibernateUtil.getSessionFactory();

	public static List<Student> getList() {
		List<Student> l = null;
		Session s = factory.openSession();

		try {

			String hql = "SELECT st FROM Student st";
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
	public static void Add(Student student) {
		Session session = factory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(student);
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
	public static void Update(Student student) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    try {
	    	
	    	tx = session.beginTransaction();
	    	session.update(student);
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
    public static void Delete(String studentID) {
    	
        Session session = factory.openSession();
        Transaction transaction = null;
        
        try {
        	
            transaction = session.beginTransaction();
            Student student = (Student) session.get(Student.class, studentID);
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
    
    public static List<Student> Find(Student student) {
		Session session = factory.openSession();
        Transaction transaction = null;
        
        try {
        	
            transaction = session.beginTransaction();
            
            String condition ="";
            if(!student.getStudentID().isEmpty()) {
            	condition += "studentID = '" +student.getStudentID()+"' and ";
            }
            if(!student.getName().isEmpty()) {
            	condition += "name = '" + student.getName()+"' and ";
            }
            if(!student.getGender().isEmpty()) {
            	condition += "gender = '" + student.getGender()+"' and ";
            }
            if(!student.getiD().isEmpty()) {
            	condition += "iD = '" + student.getiD()+"' and ";
            }
            if(!student.getClassID().isEmpty()) {
            	condition += "classID = '" + student.getClassID()+"' and ";
            }
            
            condition = condition.substring(0,condition.length()-5);
                    
            Query query = session.createQuery("from Student where " + condition );
            List<Student> result = query.list();
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
