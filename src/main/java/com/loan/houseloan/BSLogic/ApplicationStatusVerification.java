package com.loan.houseloan.BSLogic;

import com.loan.houseloan.DAO.FetchingDetailsDB;

public class ApplicationStatusVerification {
	
	public int ApplicationStatus(String userid) {
		
		int status = new FetchingDetailsDB().fetchApplicationStatus(userid);
		if(status == 1) {
			return 1;
		}
		return 0;
	}

}
