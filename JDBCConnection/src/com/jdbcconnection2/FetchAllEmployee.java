package com.jdbcconnection2;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class FetchAllEmployee {
    private static void fetchAllEmployees() {
        String sql = "SELECT * FROM employee";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                    "id: " + rs.getInt("id") + " | " +
                    "name: " + rs.getString("name") + " | " +
                    "department: " + rs.getString("dept") + " | " +
                    "salary: " + rs.getDouble("salary")
                );
            }
            System.out.println("end!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fetchAllEmployees();
    }
}
