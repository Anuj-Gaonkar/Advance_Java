package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.cdac")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileno = request.getParameter("mobileNo");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegisterService rs = new RegisterService();
		boolean isPresent = rs.isRegistered(email);
		System.out.println(isPresent);
		if (isPresent) {
			response.sendRedirect("login.html");
		} else {
			int updated = rs.insertEntry(name, email, mobileno, username, password);
			if (updated == 1) {
				response.sendRedirect("success.html");
			} else {
				out.write("<html><body>");
				out.write("<h1>Not Successful</h1>");
				out.write("</body></html>");
			}
		}
		
	}

}

