package com.loan.houseloan.BSLogic;

import com.loan.houseloan.DAO.AdminDetailsDB;
import com.loan.houseloan.DAO.FetchingDetailsDB;
import com.loan.houseloan.Model.LoanStandards;
import com.loan.houseloan.Model.UserDetails;

public class AdminVerification {

	public int validateAdmin(String adminId, String adminPwd) {

		String dbAdminPassword = AdminDetailsDB.getPassword(adminId);

		if (adminPwd.equals(dbAdminPassword)) {
			return 1;
		}
		return 0;
	}

	public int approvingApplication(String userid) {
		int value = new AdminDetailsDB().Approve(userid);
		if (value == 1) {
			return 1;
		}
		return 0;
	}

	public int checkApprovalvalidity(String userid) {

		int score = 0;
//		private int loanAmount;

		FetchingDetailsDB fetchDetails = new FetchingDetailsDB();
		UserDetails user = fetchDetails.getUserDetailsForApproval(userid);

		int userage = user.getAge();
		int userCreditScore = user.getCreditScore();
		int userDistanceFromBank = user.getDistanceFromBank();
		int userRepaymentPeriod = user.getRepaymentPeriod();
		int userWorkExperience = user.getWorkExperience();
		int userOccupation = user.getOccupation();
		int userRelationWithBank = user.getRelationWithBank();

		LoanStandards loanStandards = fetchDetails.fetchingLoanStandards();

		if (userage >= loanStandards.getMinAge() && userage <= loanStandards.getMaxAge()) {
			score++;
		}
		if (userCreditScore >= loanStandards.getMincreditScore()
				&& userCreditScore <= loanStandards.getMaxcreditScore()) {
			score++;
		}
		if (userDistanceFromBank >= loanStandards.getMindistanceFromBank()
				&& userDistanceFromBank <= loanStandards.getMaxdistanceFromBank()) {
			score++;
		}
		if (userRepaymentPeriod >= loanStandards.getMinrepaymentPeriod()
				&& userRepaymentPeriod <= loanStandards.getMaxrepaymentPeriod()) {
			score++;
		}
		if (userWorkExperience >= loanStandards.getMinworkExperience()
				&& userWorkExperience <= loanStandards.getMaxworkExperience()) {
			score++;
		}
		if (userOccupation == 1) {
			score++;
		}
		if (userRelationWithBank == 1) {
			score++;
		}
		return score;
	}
}
