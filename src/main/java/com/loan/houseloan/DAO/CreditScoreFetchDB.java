package com.loan.houseloan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.loan.houseloan.Model.CreditScoreDetails;

public class CreditScoreFetchDB {

	static SessionFactory sf;
	static Session session;
	static Transaction trans;
	static Configuration config;

	public static Session getSession() {
		sf = new Configuration().configure().buildSessionFactory();
		return sf.openSession();
	}

	public static int getCreditScore(String panCard) {

		session = getSession();
		System.out.println("Fetching credit score for : "+panCard);
		
		CreditScoreDetails creditScore = (CreditScoreDetails)session.get(CreditScoreDetails.class, panCard);
		System.out.println(creditScore.getCreditScore());
//		String creditScore1 = String.valueOf(creditScore.getCreditScore());
//		if(creditScore1.equals(null)) {
//			return 0;
//		}
//		return 0;
		return creditScore.getCreditScore();
	}

}
