package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String check = request.getParameter("op");
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(check);
		
		switch (check) {
			case "+":
				out.write("<head><body>");
				out.write("<p>"+ (num1 + num2) +"</p>");
				out.write("</body></head>");
				break;
			case "-":
				out.write("<head><body>");
				out.write("<p>"+ (num1 - num2) +"</p>");
				out.write("</body></head>");
				break;
			case "*":
				out.write("<head><body>");
				out.write("<p>"+ (num1 * num2) +"</p>");
				out.write("</body></head>");
				break;
			case "/":
				out.write("<head><body>");
				out.write("<p>"+ (num1 / num2) +"</p>");
				out.write("</body></head>");
				break;
		}
		
	}

}
