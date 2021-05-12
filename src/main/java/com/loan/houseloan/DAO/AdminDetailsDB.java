package com.loan.houseloan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.loan.houseloan.Model.AdminDetails;
import com.loan.houseloan.Model.UserDetails;

public class AdminDetailsDB {
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
		AdminDetails a = (AdminDetails) session.get(AdminDetails.class, userid);
		System.out.println(a);
		return a.getAdminPassword();
	}
	
	public int Approve(String userid) {
		
		session = getSession();
		System.out.println("Validating..............");
		System.out.println(userid);
		UserDetails userDetails = (UserDetails)session.get(UserDetails.class, userid);
		userDetails.setApprovedStatus(true);
		Transaction tx = session.beginTransaction();
		session.update(userDetails);
		tx.commit();
		return 1;
	}
}
