package com.cdac.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.MainDao;
import com.cdac.entity.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		MainDao dao = new MainDao();
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		boolean isValid = false;
		
		isValid = dao.loginVerification(userid, password);
		
		if (isValid) {
			out.write("<html><body>");
			out.write("<h2>LoggedIN</h2>");
			out.write("</body></html>");
		} else {
			out.write("<html><body>");
			out.write("<h2>Username = user not found</h2>");
			out.write("</body></html>");
		}
		
	}


}
