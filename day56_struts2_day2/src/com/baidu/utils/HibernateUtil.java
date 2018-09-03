package com.baidu.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		
		Configuration configuration=new Configuration();
		configuration.configure();
		factory=configuration.buildSessionFactory();
	}
	
	public static Session openSession() {
		return factory.openSession();
	}
	
	public static Session getCurrentSession() {
		return factory.getCurrentSession();
	}
}
