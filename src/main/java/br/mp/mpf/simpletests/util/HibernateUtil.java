package br.mp.mpf.simpletests.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory factory;

	static {

		Configuration config = new Configuration()
				.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		factory = config.buildSessionFactory(serviceRegistry);
	}

	public static SessionFactory getFactory() {
		return factory;
	}

	public static synchronized Session getSession() {
		return factory.openSession();
	}

	public static void shutdown() {
		factory.close();
	}

}
