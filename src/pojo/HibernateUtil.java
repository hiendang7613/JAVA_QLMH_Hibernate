package pojo;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			sessionFactory = conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactor failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

