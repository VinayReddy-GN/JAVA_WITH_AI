package com.webpageproject;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html><head><title>Index Servlet</title></head>");
        out.println("<body><h1>Welcome to the Index Servlet</h1></body></html>");
    }
}
