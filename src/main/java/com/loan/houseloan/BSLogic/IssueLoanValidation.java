package com.loan.houseloan.BSLogic;

import com.loan.houseloan.DAO.FetchingDetailsDB;
import com.loan.houseloan.DAO.UpdateUserDetailsDB;
import com.loan.houseloan.Model.UserDetails;

public class IssueLoanValidation {

	public int loanApproved(String userid, int userScore) {

		int approvedAmount = 0;
		int requestedAmount = new FetchingDetailsDB().loanRequested(userid);

		if (userScore == 6) {
			approvedAmount = requestedAmount;
		} else if (userScore == 5) {
			approvedAmount = (int) (requestedAmount / 1.1);
		} else if (userScore == 4) {
			approvedAmount = (int) (requestedAmount / 1.25);
		} else if (userScore == 3 || userScore <= 3) {
			approvedAmount = (int) (requestedAmount / 1.5);
		}
		
		UpdateUserDetailsDB updateUserDetails = new UpdateUserDetailsDB();
		int status = updateUserDetails.UpdateAmount(userid, approvedAmount);
		if(status == 1) {
			System.out.println("Amount updated in user details");
		}
		return approvedAmount;
	}

	public int UserApproval(String userid) {
		
		UpdateUserDetailsDB updateDetails = new UpdateUserDetailsDB();
		int status = updateDetails.ChoiceUpdationStatus(userid);
		if(status == 1) {
			return 1;
		}
		return 0;
	}
}
