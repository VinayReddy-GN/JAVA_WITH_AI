package com.college;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDetails {

    // 1. INSERT
    public static void insertStudent(Connection con, Scanner sc) throws SQLException {
        System.out.print("  Name  : ");
        String name = sc.nextLine();
        System.out.print("  Email : ");
        String email = sc.nextLine();
        System.out.print("  USN   : ");
        String usn = sc.nextLine();

        String sql = "INSERT INTO students (student_name, student_email, student_usn) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, usn);
            System.out.println("  Rows inserted: " + ps.executeUpdate());
        }
    }

    // 2. VIEW ALL
    public static void viewAllStudents(Connection con) throws SQLException {
        String sql = "SELECT * FROM students ORDER BY student_id";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            System.out.printf("%n  %-5s %-20s %-30s %-10s%n", "ID", "Name", "Email", "USN");
            System.out.println("  " + "-".repeat(70));
            boolean any = false;
            while (rs.next()) {
                any = true;
                System.out.printf("  %-5d %-20s %-30s %-10s%n",
                        rs.getInt("student_id"),
                        rs.getString("student_name"),
                        rs.getString("student_email"),
                        rs.getString("student_usn"));
            }
            if (!any) System.out.println("  (no records)");
        }
    }

    // 3. SEARCH BY ID
    public static void searchStudentById(Connection con, Scanner sc) throws SQLException {
        System.out.print("  Student ID: ");
        int id = Integer.parseInt(sc.nextLine());
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM students WHERE student_id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.printf("%n  ID:%d  Name:%s  Email:%s  USN:%s%n",
                            rs.getInt("student_id"),
                            rs.getString("student_name"),
                            rs.getString("student_email"),
                            rs.getString("student_usn"));
                } else {
                    System.out.println("  Not found.");
                }
            }
        }
    }

    // 4. UPDATE
    public static void updateStudent(Connection con, Scanner sc) throws SQLException {
        System.out.print("  ID to update : ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("  New Name     : ");
        String name = sc.nextLine();
        System.out.print("  New Email    : ");
        String email = sc.nextLine();
        System.out.print("  New USN      : ");
        String usn = sc.nextLine();

        String sql = "UPDATE students SET student_name=?, student_email=?, student_usn=? WHERE student_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, usn);
            ps.setInt(4, id);
            System.out.println(ps.executeUpdate() > 0 ? "  Updated!" : "  Not found.");
        }
    }

    // 5. DELETE
    public static void deleteStudent(Connection con, Scanner sc) throws SQLException {
        System.out.print("  ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE student_id=?")) {
            ps.setInt(1, id);
            System.out.println(ps.executeUpdate() > 0 ? "  Deleted!" : "  Not found.");
        }
    }

    // 6. MAIN MENU
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection con = DBConnection.getConnection()) {  // <-- You need a DBConnection class
            System.out.println("  Connected!");
            int choice;
            do {
                System.out.println("");
                System.out.println("  ===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("  1. Insert Student");
                System.out.println("  2. View All Students");
                System.out.println("  3. Search Student by ID");
                System.out.println("  4. Update Student");
                System.out.println("  5. Delete Student");
                System.out.println("  6. Exit");
                System.out.print("  Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1: insertStudent(con, sc);     break;
                    case 2: viewAllStudents(con);       break;
                    case 3: searchStudentById(con, sc); break;
                    case 4: updateStudent(con, sc);     break;
                    case 5: deleteStudent(con, sc);     break;
                    case 6: System.out.println("  Goodbye!"); break;
                    default: System.out.println("  Invalid. Enter 1-6.");
                }
            } while (choice != 6);
        } catch (SQLException e) {
            System.err.println("  DB error: " + e.getMessage());
        }
        sc.close();
    }
}
