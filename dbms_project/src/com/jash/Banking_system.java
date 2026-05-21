package com.jash;

import java.sql.*;
import java.util.Scanner;

public class Banking_system {

    // ================= DESIGN METHODS =================

    public static void line() {

        System.out.println("==============================================================================================================");
    }

    public static void title(String name) {

        line();
        System.out.printf("%60s\n", name);
        line();
    }

    // ================= CUSTOMER =================

    public static void viewCustomer(Connection con) throws SQLException {

        String sql = "SELECT * FROM Customer";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("CUSTOMER TABLE");

        System.out.printf("%-5s %-12s %-12s %-12s %-12s %-15s %-15s\n",
                "ID", "FIRST", "LAST", "GENDER", "CITY", "PHONE", "OCCUPATION");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-12s %-12s %-12s %-12s %-15s %-15s\n",

                    rs.getInt("Customer_ID"),
                    rs.getString("First_Name"),
                    rs.getString("Last_Name"),
                    rs.getString("Gender"),
                    rs.getString("City"),
                    rs.getString("Phone"),
                    rs.getString("Occupation"));
        }

        line();
    }

    // ================= BRANCH =================

    public static void viewBranch(Connection con) throws SQLException {

        String sql = "SELECT * FROM Branch";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("BRANCH TABLE");

        System.out.printf("%-5s %-25s %-20s %-15s %-15s\n",
                "ID", "BRANCH NAME", "MANAGER", "IFSC", "PHONE");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-25s %-20s %-15s %-15s\n",

                    rs.getInt("Branch_ID"),
                    rs.getString("Branch_Name"),
                    rs.getString("Manager_Name"),
                    rs.getString("IFSC_Code"),
                    rs.getString("Phone"));
        }

        line();
    }

    // ================= ACCOUNT =================

    public static void viewAccount(Connection con) throws SQLException {

        String sql = "SELECT * FROM Account";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("ACCOUNT TABLE");

        System.out.printf("%-12s %-10s %-10s %-15s %-15s %-10s\n",
                "ACCOUNT NO", "CUST ID", "BRANCH", "TYPE", "BALANCE", "STATUS");

        line();

        while (rs.next()) {

            System.out.printf("%-12d %-10d %-10d %-15s %-15.2f %-10s\n",

                    rs.getLong("Account_No"),
                    rs.getInt("Customer_ID"),
                    rs.getInt("Branch_ID"),
                    rs.getString("Account_Type"),
                    rs.getDouble("Balance"),
                    rs.getString("Status"));
        }

        line();
    }

    // ================= EMPLOYEE =================

    public static void viewEmployee(Connection con) throws SQLException {

        String sql = "SELECT * FROM Employee";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("EMPLOYEE TABLE");

        System.out.printf("%-5s %-10s %-15s %-15s %-15s %-12s\n",
                "ID", "BRANCH", "FIRST NAME", "LAST NAME", "DESIGNATION", "SALARY");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-10d %-15s %-15s %-15s %-12.2f\n",

                    rs.getInt("Employee_ID"),
                    rs.getInt("Branch_ID"),
                    rs.getString("First_Name"),
                    rs.getString("Last_Name"),
                    rs.getString("Designation"),
                    rs.getDouble("Salary"));
        }

        line();
    }

    // ================= TRANSACTIONS =================

    public static void viewTransactions(Connection con) throws SQLException {

        String sql = "SELECT * FROM Transactions";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("TRANSACTIONS TABLE");

        System.out.printf("%-5s %-12s %-15s %-12s %-12s %-12s\n",
                "ID", "ACCOUNT", "TYPE", "AMOUNT", "MODE", "STATUS");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-12d %-15s %-12.2f %-12s %-12s\n",

                    rs.getInt("Transaction_ID"),
                    rs.getLong("Account_No"),
                    rs.getString("Transaction_Type"),
                    rs.getDouble("Amount"),
                    rs.getString("Mode"),
                    rs.getString("Status"));
        }

        line();
    }

    // ================= LOAN =================

    public static void viewLoan(Connection con) throws SQLException {

        String sql = "SELECT * FROM Loan";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("LOAN TABLE");

        System.out.printf("%-5s %-10s %-15s %-15s %-15s %-12s\n",
                "ID", "CUST ID", "LOAN TYPE", "AMOUNT", "INTEREST", "STATUS");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-10d %-15s %-15.2f %-15.2f %-12s\n",

                    rs.getInt("Loan_ID"),
                    rs.getInt("Customer_ID"),
                    rs.getString("Loan_Type"),
                    rs.getDouble("Loan_Amount"),
                    rs.getDouble("Interest_Rate"),
                    rs.getString("Loan_Status"));
        }

        line();
    }

    // ================= CREDIT CARD =================

    public static void viewCreditCard(Connection con) throws SQLException {

        String sql = "SELECT * FROM Credit_Card";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("CREDIT CARD TABLE");

        System.out.printf("%-5s %-10s %-20s %-15s %-15s\n",
                "ID", "CUST ID", "CARD NUMBER", "CARD TYPE", "LIMIT");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-10d %-20s %-15s %-15.2f\n",

                    rs.getInt("Card_ID"),
                    rs.getInt("Customer_ID"),
                    rs.getString("Card_Number"),
                    rs.getString("Card_Type"),
                    rs.getDouble("Credit_Limit"));
        }

        line();
    }

    // ================= ATM =================

    public static void viewATM(Connection con) throws SQLException {

        String sql = "SELECT * FROM ATM";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("ATM TABLE");

        System.out.printf("%-5s %-10s %-20s %-20s %-15s\n",
                "ID", "BRANCH", "LOCATION", "ATM TYPE", "CASH");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-10d %-20s %-20s %-15.2f\n",

                    rs.getInt("ATM_ID"),
                    rs.getInt("Branch_ID"),
                    rs.getString("Location"),
                    rs.getString("ATM_Type"),
                    rs.getDouble("Cash_Available"));
        }

        line();
    }

    // ================= INTERNET BANKING =================

    public static void viewInternetBanking(Connection con) throws SQLException {

        String sql = "SELECT * FROM Internet_Banking";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("INTERNET BANKING TABLE");

        System.out.printf("%-5s %-10s %-20s %-20s %-15s\n",
                "ID", "CUST ID", "USERNAME", "SECURITY QUESTION", "STATUS");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-10d %-20s %-20s %-15s\n",

                    rs.getInt("Internet_ID"),
                    rs.getInt("Customer_ID"),
                    rs.getString("Username"),
                    rs.getString("Security_Question"),
                    rs.getString("Status"));
        }

        line();
    }

    // ================= BENEFICIARY =================

    public static void viewBeneficiary(Connection con) throws SQLException {

        String sql = "SELECT * FROM Beneficiary";

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        title("BENEFICIARY TABLE");

        System.out.printf("%-5s %-10s %-20s %-15s %-15s\n",
                "ID", "CUST ID", "BENEFICIARY", "BANK", "IFSC");

        line();

        while (rs.next()) {

            System.out.printf("%-5d %-10d %-20s %-15s %-15s\n",

                    rs.getInt("Beneficiary_ID"),
                    rs.getInt("Customer_ID"),
                    rs.getString("Beneficiary_Name"),
                    rs.getString("Bank_Name"),
                    rs.getString("IFSC_Code"));
        }

        line();
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DBConnection.getConnection()) {

            int choice;

            do {

                System.out.println("\n");
                line();
                System.out.println("\t\t\t     BANKING MANAGEMENT SYSTEM");
                line();

                System.out.println("\t1.  CUSTOMER TABLE");
                System.out.println("\t2.  BRANCH TABLE");
                System.out.println("\t3.  ACCOUNT TABLE");
                System.out.println("\t4.  EMPLOYEE TABLE");
                System.out.println("\t5.  TRANSACTIONS TABLE");
                System.out.println("\t6.  LOAN TABLE");
                System.out.println("\t7.  CREDIT CARD TABLE");
                System.out.println("\t8.  ATM TABLE");
                System.out.println("\t9.  INTERNET BANKING TABLE");
                System.out.println("\t10. BENEFICIARY TABLE");
                System.out.println("\t11. EXIT");

                line();

                System.out.print("ENTER YOUR CHOICE : ");

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        viewCustomer(con);
                        break;

                    case 2:
                        viewBranch(con);
                        break;

                    case 3:
                        viewAccount(con);
                        break;

                    case 4:
                        viewEmployee(con);
                        break;

                    case 5:
                        viewTransactions(con);
                        break;

                    case 6:
                        viewLoan(con);
                        break;

                    case 7:
                        viewCreditCard(con);
                        break;

                    case 8:
                        viewATM(con);
                        break;

                    case 9:
                        viewInternetBanking(con);
                        break;

                    case 10:
                        viewBeneficiary(con);
                        break;

                    case 11:
                        System.out.println("\nTHANK YOU FOR USING BANKING MANAGEMENT SYSTEM");
                        break;

                    default:
                        System.out.println("\nINVALID CHOICE");
                }

            } while (choice != 11);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        sc.close();
    }
}