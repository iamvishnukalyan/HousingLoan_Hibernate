package com.loan.houseloan.BSLogic;

import com.loan.houseloan.DAO.SignInDetailsDB;

public class SignInVerification {

	public int loginValidation(String userid, String password) {

		String dbPassword = SignInDetailsDB.getPassword(userid);

		if (dbPassword.equals(password)) {
			return 1;
		}
		return 0;
	}
}
