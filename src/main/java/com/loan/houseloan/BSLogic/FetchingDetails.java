package com.loan.houseloan.BSLogic;

import com.loan.houseloan.DAO.CreditScoreFetchDB;
import com.loan.houseloan.DAO.FetchingDetailsDB;

public class FetchingDetails {

	public int getUserDetails(String userid) {

		System.out.println("Fetching details of: " + userid);

		int status = FetchingDetailsDB.getUserDetails(userid);
		if (status == 1) {
			return 1;
		}
		return 0;
	}
	
	public int getCreditScore(String panCardNumber) {
		
		System.out.println("Fetching your credit score...");
		
		int creditScore = CreditScoreFetchDB.getCreditScore(panCardNumber);
		
		return creditScore;
	}
}
