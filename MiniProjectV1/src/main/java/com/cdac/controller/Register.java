package com.cdac.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.MainDao;
import com.cdac.entity.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobilenumber");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(name, email, mobileNumber, username, password);
		MainDao dao = new MainDao();
		dao.registerUser(user);
		
	}

}
