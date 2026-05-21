package com.helloworld;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pr = resp.getWriter();
		pr.println("<html><body style = 'padding:40px;'>");
		pr.println("<h1 style = 'color: blue;'>Hello World !!!</h1>");
		pr.println("<p> this is my first servlet program /n so lets begin</p>");
		pr.println("</body></html>");
		
	}
	
	
	

}
