package com.jdbcconnection2;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateEmployee {
    private static void updateEmployee(int id, String name, String dept, double salary) {
        // Build SQL string using the parameters
        String sql = "UPDATE employee SET name='" + name + 
                     "', dept='" + dept + 
                     "', salary=" + salary + 
                     " WHERE id=" + id;

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement()) {

            int rows = st.executeUpdate(sql);
            System.out.println(rows + " row(s) affected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        updateEmployee(1, "WWW", "Finance", 55000.00);
    }
}
