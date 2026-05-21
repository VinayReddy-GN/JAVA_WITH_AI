package com.webpageproject;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        out.println("<h1>Contact Received</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Message: " + message + "</p>");
    }
}
