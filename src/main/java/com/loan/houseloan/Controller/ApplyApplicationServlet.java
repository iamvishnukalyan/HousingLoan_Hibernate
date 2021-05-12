package com.loan.houseloan.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplyApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplyApplicationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Apply Application Servlet Called");
		String userid = request.getParameter("userid");
		new SignInControllerServlet().applyLoan(userid);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
