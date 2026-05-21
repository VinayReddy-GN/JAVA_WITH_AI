package com.webpageproject;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class GalleryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!doctype html>");
        out.println("<html><head><title>Gallery Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Gallery Servlet</h1>");
        out.println("<p>Dynamic gallery content goes here.</p>");
        out.println("</body></html>");
    }
}
