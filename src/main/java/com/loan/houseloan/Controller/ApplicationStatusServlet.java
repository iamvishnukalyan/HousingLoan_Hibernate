package com.loan.houseloan.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ApplicationStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApplicationStatusServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Application Status Servlet Called");
		String userid = request.getParameter("userid");
		new SignInControllerServlet().applicationStatus(userid);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
