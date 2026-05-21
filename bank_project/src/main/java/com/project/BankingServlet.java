package com.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/banking")
public class BankingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String table = req.getParameter("table"); // e.g. ?table=customer

        out.println("<html><body style='font-family: Arial; padding:20px;'>");

        try (Connection con = DBConnection.getConnection()) {
            if (table == null) {
                out.println("<h2 style='color:red;'>Please specify a table parameter</h2>");
            } else {
                switch (table.toLowerCase()) {
                    case "customer": showCustomer(con, out); break;
                    case "branch": showBranch(con, out); break;
                    case "account": showAccount(con, out); break;
                    case "employee": showEmployee(con, out); break;
                    case "transactions": showTransactions(con, out); break;
                    case "loan": showLoan(con, out); break;
                    case "creditcard": showCreditCard(con, out); break;
                    case "atm": showATM(con, out); break;
                    case "internetbanking": showInternetBanking(con, out); break;
                    
                    default: out.println("<h2 style='color:red;'>Invalid table name</h2>");
                }
            }
        } catch (SQLException e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }

        out.println("</body></html>");
    }

    private void showCustomer(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Customer");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Customer Table</h2><table border='1'><tr><th>ID</th><th>First</th><th>Last</th><th>Gender</th><th>City</th><th>Phone</th><th>Occupation</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getInt("Customer_ID")+"</td><td>"+rs.getString("First_Name")+"</td><td>"+rs.getString("Last_Name")+"</td><td>"+rs.getString("Gender")+"</td><td>"+rs.getString("City")+"</td><td>"+rs.getString("Phone")+"</td><td>"+rs.getString("Occupation")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showBranch(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Branch");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Branch Table</h2><table border='1'><tr><th>ID</th><th>Name</th><th>Manager</th><th>IFSC</th><th>Phone</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getInt("Branch_ID")+"</td><td>"+rs.getString("Branch_Name")+"</td><td>"+rs.getString("Manager_Name")+"</td><td>"+rs.getString("IFSC_Code")+"</td><td>"+rs.getString("Phone")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showAccount(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Account");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Account Table</h2><table border='1'><tr><th>Account No</th><th>Cust ID</th><th>Branch</th><th>Type</th><th>Balance</th><th>Status</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getLong("Account_No")+"</td><td>"+rs.getInt("Customer_ID")+"</td><td>"+rs.getInt("Branch_ID")+"</td><td>"+rs.getString("Account_Type")+"</td><td>"+rs.getDouble("Balance")+"</td><td>"+rs.getString("Status")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showEmployee(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Employee");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Employee Table</h2><table border='1'><tr><th>ID</th><th>Branch</th><th>First</th><th>Last</th><th>Designation</th><th>Salary</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getInt("Employee_ID")+"</td><td>"+rs.getInt("Branch_ID")+"</td><td>"+rs.getString("First_Name")+"</td><td>"+rs.getString("Last_Name")+"</td><td>"+rs.getString("Designation")+"</td><td>"+rs.getDouble("Salary")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showTransactions(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Transactions");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Transactions Table</h2><table border='1'><tr><th>ID</th><th>Account</th><th>Type</th><th>Amount</th><th>Mode</th><th>Status</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getInt("Transaction_ID")+"</td><td>"+rs.getLong("Account_No")+"</td><td>"+rs.getString("Transaction_Type")+"</td><td>"+rs.getDouble("Amount")+"</td><td>"+rs.getString("Mode")+"</td><td>"+rs.getString("Status")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showLoan(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Loan");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Loan Table</h2><table border='1'><tr><th>ID</th><th>Cust ID</th><th>Type</th><th>Amount</th><th>Interest</th><th>Status</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getInt("Loan_ID")+"</td><td>"+rs.getInt("Customer_ID")+"</td><td>"+rs.getString("Loan_Type")+"</td><td>"+rs.getDouble("Loan_Amount")+"</td><td>"+rs.getDouble("Interest_Rate")+"</td><td>"+rs.getString("Loan_Status")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showCreditCard(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Credit_Card");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Credit Card Table</h2><table border='1'><tr><th>ID</th><th>Cust ID</th><th>Card Number</th><th>Type</th><th>Limit</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getInt("Card_ID")+"</td><td>"+rs.getInt("Customer_ID")+"</td><td>"+rs.getString("Card_Number")+"</td><td>"+rs.getString("Card_Type")+"</td><td>"+rs.getDouble("Credit_Limit")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showATM(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM ATM");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>ATM Table</h2><table border='1'><tr><th>ID</th><th>Branch</th><th>Location</th><th>Type</th><th>Cash</th></tr>");
        while (rs.next()) {
            out.println("<tr><td>"+rs.getInt("ATM_ID")+"</td><td>"+rs.getInt("Branch_ID")+"</td><td>"+rs.getString("Location")+"</td><td>"+rs.getString("ATM_Type")+"</td><td>"+rs.getDouble("Cash_Available")+"</td></tr>");
        }
        out.println("</table>");
    }

    private void showInternetBanking(Connection con, PrintWriter out) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM Internet_Banking");
        ResultSet rs = ps.executeQuery();
        out.println("<h2>Internet Banking Table</h2>");
        out.println("<table border='1'><tr><th>ID</th><th>Cust ID</th><th>Username</th><th>Security Question</th><th>Status</th></tr>");
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("Internet_ID") + "</td>");
            out.println("<td>" + rs.getInt("Customer_ID") + "</td>");
            out.println("<td>" + rs.getString("Username") + "</td>");
            out.println("<td>" + rs.getString("Security_Question") + "</td>");
            out.println("<td>" + rs.getString("Status") + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
