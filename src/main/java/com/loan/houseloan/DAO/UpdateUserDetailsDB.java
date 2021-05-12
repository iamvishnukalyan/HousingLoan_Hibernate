package com.loan.houseloan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.loan.houseloan.Model.UserDetails;

public class UpdateUserDetailsDB {
	static SessionFactory sf;
	static Session session;
	static Transaction trans;
	static Configuration config;

	public static Session getSession() {
		sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}

	public int ChoiceUpdationStatus(String userid) {
		session = getSession();
		System.out.println("Validating..............");
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userid);
		userDetails.setApprovedAmountOk(true);
		Transaction tx = session.beginTransaction();
		session.update(userDetails);
		tx.commit();
		return 1;
	}

	public int UpdateAmount(String userid, int approvedAmount) {
		session = getSession();
		System.out.println("Validating..............");
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userid);
		userDetails.setApprovedAmount(approvedAmount);
		Transaction tx = session.beginTransaction();
		session.update(userDetails);
		tx.commit();
		return 1;
	}

	public int updatedApprovedAmount(String userid) {
		session = getSession();
		System.out.println("Validating..............");
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userid);
		int updatedApprovedAmount = userDetails.getApprovedAmount();
		return updatedApprovedAmount;
	}
	
	public Boolean updatedApprovedStatus(String userid) {
		session = getSession();
		System.out.println("Validating..............");
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userid);
		Boolean updatedApprovedStatus = userDetails.isApprovedStatus();
		System.out.println(updatedApprovedStatus);
		return updatedApprovedStatus;
	}

	public int isApprovedAmountOk(String userid) {
		session = getSession();
		System.out.println("Validating..............");
		UserDetails updatedDetails = (UserDetails) session.get(UserDetails.class, userid);
//		int isApprovedAmount = updatedDetails.getApprovedAmount();
//		System.out.println(isApprovedAmount);
//		if (isApprovedAmount == 1) {
//			return 1;
//		}
//		return 0;
		System.out.println(updatedDetails.isApprovedAmountOk());
		if(updatedDetails.isApprovedAmountOk()) {
			return 1;
		}
		return 0;
	}
}
