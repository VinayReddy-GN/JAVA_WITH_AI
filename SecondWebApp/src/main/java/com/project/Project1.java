package com.project;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ABC")
public class Project1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pr = resp.getWriter();
		resp.setContentType("text/html");
		pr.println("<html><body style='padding:40px; font-family: Arial;'>");

		pr.println("<html><body style='padding:40px; font-family: Arial;'>");
		pr.println("<h1 style='color: green;'>Welcome to My Servlet!</h1>");
		pr.println("<p>This page is generated dynamically using Java Servlets.</p>");
		pr.println("<p style='color: blue;'>Learning Servlets is fun and powerful.</p>");
		pr.println("</body></html>");

		

	}
	

}
