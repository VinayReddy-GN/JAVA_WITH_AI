package com.webpageproject;

import java.io.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        out.println("<h1>Admission Application</h1>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Course: " + course + "</p>");
    }
}
