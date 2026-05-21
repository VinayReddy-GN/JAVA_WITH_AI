package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect to login page
        response.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        if ("admin".equals(username) && "1234".equals(password)) {
            pw.println("<html><body>");
            pw.println("<h2>Welcome, " + username + "!</h2>");
            pw.println("</body></html>");
        } else {
            pw.println("<html><body>");
            pw.println("<h2 style='color:red;'>Invalid credentials !!!</h2>");
            pw.println("</body></html>");
        }
    }
}
