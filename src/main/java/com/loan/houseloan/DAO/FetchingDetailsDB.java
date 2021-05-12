package com.loan.houseloan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.loan.houseloan.Model.LoanStandards;
import com.loan.houseloan.Model.UserDetails;

public class FetchingDetailsDB {
	static SessionFactory sf;
	static Session session;
	static Transaction trans;
	static Configuration config;

	public static Session getSession() {
		sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}
	
	public int fetchApplicationStatus(String userid) {
		session = getSession();
		System.out.println("Validating..............");
		System.out.println("Your userid is: " + userid);
		UserDetails a = (UserDetails) session.get(UserDetails.class, userid);
		if(a.isApprovedStatus()) {
			return 1;
		}
		return 0;
	}

	public static int getUserDetails(String userid) {

		session = getSession();
		System.out.println("Validating..............");
		System.out.println("Your userid is: " + userid);
		UserDetails a = (UserDetails) session.get(UserDetails.class, userid);

		System.out.println("Age : " + a.getAge());
		System.out.println("Pan Card Number: " + a.getPanCardNumber());
		System.out.println("Repayment Period: " + a.getRepaymentPeriod());
		System.out.println("Work Experience: " + a.getWorkExperience());
		System.out.println("Distance: " + a.getDistanceFromBank());
		System.out.println("Credit Score: " + a.getCreditScore());
		System.out.println("Occupation: " + a.getOccupation());
		System.out.println("Application Status: "+a.isApprovedStatus());
		return 1;
	}
	
	public LoanStandards fetchingLoanStandards() {
		session = getSession();
		LoanStandards loanStandards = (LoanStandards) session.get(LoanStandards.class, "homeloan");
		return loanStandards;
	}
	
	public UserDetails getUserDetailsForApproval(String userid) {
		session = getSession();
		System.out.println("Validating..............");
		System.out.println("Your userid is: " + userid);
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userid);
		return userDetails;
	}
	
	public int loanRequested(String userid) {
		session = getSession();
		System.out.println("Validating..............");
		System.out.println("Your userid is: " + userid);
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, userid);
		int amount = userDetails.getLoanAmount();
		return amount;
	}
}
