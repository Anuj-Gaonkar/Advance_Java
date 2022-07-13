package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.service.LoginService;

/**
 * Servlet implementation class LoginFromDB
 */
@WebServlet("/login.cdac")
public class LoginFromDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginService ls = new LoginService();
		boolean success = ls.isValid(username, password);
		System.out.println(success);
		if (success) {
			String rememberMe = request.getParameter("rememberMe");
			if(rememberMe != null && rememberMe.equals("yes")) {
				Cookie c1 = new Cookie("uname", username);
				c1.setMaxAge(60 * 30);
				Cookie c2 = new Cookie("upass", password);
				c2.setMaxAge(60 * 30);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		} else {
			response.sendRedirect("login.html");
		}
		
	}

}
