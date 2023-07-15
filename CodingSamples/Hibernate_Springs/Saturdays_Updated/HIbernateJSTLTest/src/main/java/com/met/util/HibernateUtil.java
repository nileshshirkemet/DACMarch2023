package com.met.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
	
}
