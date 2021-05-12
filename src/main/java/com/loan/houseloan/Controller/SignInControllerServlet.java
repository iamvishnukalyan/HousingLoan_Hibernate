package com.loan.houseloan.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.sql.Update;

import com.loan.houseloan.BSLogic.ApplicationStatusVerification;
import com.loan.houseloan.BSLogic.DetailsValidation;
import com.loan.houseloan.BSLogic.FetchingDetails;
import com.loan.houseloan.BSLogic.IssueLoanValidation;
import com.loan.houseloan.DAO.UpdateUserDetailsDB;
import com.loan.houseloan.Model.CustomerDetails;
import com.loan.houseloan.Model.UserDetails;

public class SignInControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Scanner sc = new Scanner(System.in);
	HttpServletResponse response;

	public SignInControllerServlet() {
		super();
	}

	public void applicationStatus(String userid) throws ServletException, IOException {

		System.out.println("Checnking your application status.....");
		UserDetails userDetails = new UserDetails();
		UpdateUserDetailsDB updatedValues = new UpdateUserDetailsDB();
		
		if(updatedValues.updatedApprovedStatus(userid)) {
			//response.sendRedirect("Approved.jsp");
			System.out.println("Approved");
		}else {
			if (userDetails.isApprovedAmountOk()) {
				System.out.println("You said ok for " + userDetails.getApprovedAmount());
				int status = new ApplicationStatusVerification().ApplicationStatus(userid);
				if (status == 1) {
					response.sendRedirect("Approved.jsp");
					System.out.println("Your Application is APPROVED");
				} else {
					System.out.println("Your Application is yet to be approved");
				}
			} else {
				// change
				System.out.println("Your approved amount is: " + updatedValues.updatedApprovedAmount(userid));
				System.out
						.println("If you wish to continue the process for " + userDetails.getApprovedAmount() + "press 1");
				int choice = sc.nextInt();
				if (choice == 1) {
					System.out.println("Submitting the application for " + userDetails.getApprovedAmount());
					int status = new IssueLoanValidation().UserApproval(userid);
					if (status == 1) {
						System.out.println("Application Submitted Successfully");
					}
				}
			}
		}
		
		

	}

	public int applyLoan(String userid) {

//		response.sendRedirect("ApplyApplication.jsp");

		System.out.println("Fill the details to apply the new loan");

		UserDetails userDetails = new UserDetails();
		userDetails.setId(userid);

		System.out.println("Enter your age: ");
		int age = sc.nextInt();
		userDetails.setAge(age);

		System.out.println("Enter your PAN Number: ");
		String panNumber = sc.next();
		sc.nextLine();
		userDetails.setPanCardNumber(panNumber);

		System.out.println("Finding your credit score using PAN number");
		System.out.println("..........................................");
		int creditScore = new FetchingDetails().getCreditScore(panNumber);

		System.out.println("Your Credit Score is: " + creditScore);
		userDetails.setCreditScore(creditScore);

		System.out.println("Enter the loan amount: ");
		int laonAmnt = sc.nextInt();
		userDetails.setLoanAmount(laonAmnt);

		System.out.println("Enter the distance from bank: ");
		int distance = sc.nextInt();
		userDetails.setDistanceFromBank(distance);

		System.out.println("Enter the repayment period (In years): ");
		int repayPeriod = sc.nextInt();
		userDetails.setRepaymentPeriod(repayPeriod);

		System.out.println("Enter your work Experience: ");
		int workExp = sc.nextInt();
		userDetails.setWorkExperience(workExp);

		System.out.println("Enter your relaption with bank: ");
		int relation = sc.nextInt();
		userDetails.setRelationWithBank(relation);

		int validationStatus = new DetailsValidation().ForDetailsValidation(userDetails);
		if (validationStatus == 1) {
			return 1;
		}
		return 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
//		rd.include(request, response);

		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");

		CustomerDetails customer = new CustomerDetails();
		customer.setUserid(id);
		customer.setPassword(pwd);

		int value = customer.loginValidate();
		if (value == 1) {
			System.out.println("Worked........!");
			System.out.println("Welcome " + customer.getUserid());
			response.sendRedirect("SignedInUserChoice.jsp");

//			System.out.println("Select your choice");
//			System.out.println("1. View Application Status");
//			System.out.println("2. Apply New Loan");
//			int choice = sc.nextInt();
//			if (choice == 1) {
//				
//				//PrintWriter out = response.getWriter();
//				//out.print("Viewing application");
//				
//				response.sendRedirect("ApplicationStatus.jsp");
//				System.out.println("not worked");
////				new SignInControllerServlet().applicationStatus(id);
//			} else if (choice == 2) {
//				response.sendRedirect("ApplyApplication.jsp");
//				System.out.println("not worked");
//
//				//int choiceStatus = new SignInControllerServlet().applyLoan(id);
////				if (choiceStatus == 1) {
////					System.out.println("user Details Insertion completed...!");
////				} else {
////					System.out.println("Something is wrong");
////				}
//			}

		} else {
			System.out.println("seems like you are a new user");
			System.out.println("Wrong password");
		}
	}
}
