package com.loan.houseloan.Controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.houseloan.BSLogic.AdminVerification;
import com.loan.houseloan.BSLogic.FetchingDetails;
import com.loan.houseloan.BSLogic.IssueLoanValidation;
import com.loan.houseloan.DAO.UpdateUserDetailsDB;
import com.loan.houseloan.Model.AdminDetails;
import com.loan.houseloan.Model.UserDetails;

public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Scanner sc = new Scanner(System.in);

	public AdminInfoServlet() {
		super();
	}

	public void viewApplication() {
		System.out.println("You have chose to view the application");
		System.out.println("Enter the userid:");
		String userid = sc.next();
		sc.nextLine();
		System.out.println("userid is: " + userid);
		new FetchingDetails().getUserDetails(userid);

		System.out.println("Press 1 to Check Approval Validity.... of " + userid);
		int choice = sc.nextInt();
		if (choice == 1) {
			new AdminInfoServlet().checkApprovalValidity(userid);
		}
	}

	public void checkApprovalValidity(String userid) {
		System.out.println("Checking approval validity");
		int userScore = new AdminVerification().checkApprovalvalidity(userid);
		System.out.println("User Score is: " + userScore + "/6");

		int approvedAmount = new IssueLoanValidation().loanApproved(userid, userScore);
		System.out.println("Amount for approval is: " + approvedAmount);

		UpdateUserDetailsDB updatedDetails = new UpdateUserDetailsDB();
		int userChoice = updatedDetails.isApprovedAmountOk(userid);
		System.out.println(userChoice);
		if (userChoice == 1) {
			System.out.println("Ha said yes for " + approvedAmount);
		} else {
			System.out.println(userid+"'s decision is pending for " + approvedAmount);
		}

		System.out.println("press 1 to go to the approval process");
		int choicea = sc.nextInt();
		if (choicea == 1) {
			System.out.println("Approving the " + userid + " application");
			new AdminVerification().approvingApplication(userid);
			System.out.println("Application Approved.....!");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("adminuserid");
		String pwd = request.getParameter("adminpassword");

		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setAdminUserId(id);
		adminDetails.setAdminPassword(pwd);

		int value = new AdminVerification().validateAdmin(id, pwd);
		if (value == 1) {
			System.out.println("Admin Validated");

//			response.setContentType("text/html");
//			response.sendRedirect(request.getContextPath()+"/ViewApplications.jsp");
			
			RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/ViewApplications.jsp");
            requestDispatcher.forward(request, response);
            
			System.out.println("Press 1 to view the application");
			int choice = sc.nextInt();
			if (choice == 1) {
				new AdminInfoServlet().viewApplication();
			} else {
				System.out.println("wrong option entered");
			}
		} else {
			System.out.println("Wrong Details Entered");
		}

	}

}
