package com.loan.houseloan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.loan.houseloan.Model.CustomerDetails;

public class SignUpDetailsDB {
	static SessionFactory sf;
	static Session session;
	static Transaction trans;
	static Configuration config;

	public static Session getSession() {
		sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}

	public static int getSignUpStatus(CustomerDetails customer) {
		
		System.out.println("Validating..............");
		session=getSession();
		trans=session.beginTransaction();
		session.save(customer);
		trans.commit();
		System.out.println("User added successfully");
		return 1;
	}

}
