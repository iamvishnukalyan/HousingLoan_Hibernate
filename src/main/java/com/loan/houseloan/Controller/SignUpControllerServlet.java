package com.loan.houseloan.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loan.houseloan.BSLogic.SignInVerification;
import com.loan.houseloan.BSLogic.SignUpVerification;
import com.loan.houseloan.Model.CustomerDetails;

public class SignUpControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUpControllerServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Scanner sc = new Scanner(System.in);
		
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		int age1 = Integer.parseInt(age);
		String phnNum = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		
		CustomerDetails customer = new CustomerDetails();
		customer.setUserid(id);
		customer.setPassword(pwd);
		customer.setName(name);
		customer.setAge(age1);
		customer.setPhoneNumber(phnNum);
		customer.setEmail(email);
		customer.setAddress(address);
		customer.setCity(city);
		
		int value = SignUpVerification.UserInsertion(customer);
		if (value == 1) {
			
			System.out.println("Worked........!");
			System.out.println("Welcome "+id);
			System.out.println("You can apply for a new House Loan");
			
			PrintWriter out = response.getWriter();
			out.println("User Added successfully");
			response.sendRedirect("NewApplication.jsp");
			
			
			System.out.println("Press 1 to apply for a new House Loan");
			
			int choice = sc.nextInt();
			if(choice ==1) {
				
				//applyLoan(id)
				new SignInControllerServlet().applyLoan(id);
			}else {
				System.out.println("Session Expried ");
				System.out.println("Login again...");
				RequestDispatcher rd = request.getRequestDispatcher("/SignInControllerServlet");
				rd.forward(request, response);
			}
			
		}else {
			System.out.println();
		}
	}

}
