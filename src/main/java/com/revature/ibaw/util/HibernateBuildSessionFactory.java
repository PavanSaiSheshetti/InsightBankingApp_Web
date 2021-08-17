package com.revature.ibaw.util;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateBuildSessionFactory {

//	public HibernateBuildSessionFactory() {
//		// TODO Auto-generated constructor stub
//	}
	public static SessionFactory getSessionFactory() {
		
		AnnotationConfiguration configuration=new AnnotationConfiguration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
	}

}
