package com.loan.houseloan.BSLogic;

import com.loan.houseloan.DAO.SignUpDetailsDB;
import com.loan.houseloan.Model.CustomerDetails;

public class SignUpVerification {
	public static int UserInsertion(CustomerDetails customer) {

		System.out.println("Details Verified.. Inserting");

		int value = SignUpDetailsDB.getSignUpStatus(customer);

		if (value == 1) {
			return 1;
		}
		return 0;
	}
}
