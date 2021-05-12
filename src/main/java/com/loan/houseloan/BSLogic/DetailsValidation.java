package com.loan.houseloan.BSLogic;

import com.loan.houseloan.DAO.InsertDetailsDB;
import com.loan.houseloan.Model.UserDetails;

public class DetailsValidation {

	public int ForDetailsValidation(UserDetails userDetails) {
		
		System.out.println("Inserting into table");

		new InsertDetailsDB();

		int insertionStatus = InsertDetailsDB.getInsertionStatus(userDetails);
		if (insertionStatus == 1) {
			return 1;
		}
		return 0;
	}
}
