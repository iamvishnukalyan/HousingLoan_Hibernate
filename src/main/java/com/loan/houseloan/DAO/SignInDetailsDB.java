package com.loan.houseloan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.loan.houseloan.Model.CustomerDetails;

public class SignInDetailsDB {
	static SessionFactory sf;
	static Session session;
	static Transaction trans;
	static Configuration config;
	
	public static Session getSession() {
		sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}

	public static String getPassword(String userid) {

		session = getSession();
		System.out.println("Validating..............");
		System.out.println(userid);
		CustomerDetails a = (CustomerDetails)session.get(CustomerDetails.class, userid);
		System.out.println(a);
		return a.getPassword();
	}


}
