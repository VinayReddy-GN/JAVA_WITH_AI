package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection3 {
    public static void main(String[] args) {
        try {
            // 1. Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            String url = "jdbc:mysql://localhost:3306/company";
            String user = "root";
            String password = "Vinay@9105";
            Connection connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection successful!!");
            System.out.println("Connected to DB: " + connection.getCatalog());

            // 3. Create statement
            Statement st = connection.createStatement();

            // 4. Drop table if exists, then create fresh
            st.executeUpdate("DROP TABLE IF EXISTS employee");
            String sql = "CREATE TABLE employee (" +
                         "id INT PRIMARY KEY AUTO_INCREMENT, " +
                         "name VARCHAR(20), " +
                         "dept VARCHAR(20), " +
                         "salary DOUBLE)";
            st.executeUpdate(sql);
            System.out.println("Table created successfully!");

            // 5. Insert sample data
            st.executeUpdate("INSERT INTO employee (name, dept, salary) VALUES ('ABC','Engineering',82000.12)");
            st.executeUpdate("INSERT INTO employee (name, dept, salary) VALUES ('XYZ','Marketing',55000.00)");
            st.executeUpdate("INSERT INTO employee (name, dept, salary) VALUES ('PQR','Sales',48000.34)");
            st.executeUpdate("INSERT INTO employee (name, dept, salary) VALUES ('MNO','HR',46000.00)");
            st.executeUpdate("INSERT INTO employee (name, dept, salary) VALUES ('EFG','Finance',67000.90)");

            // 6. Query data
            ResultSet rs = st.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   " | Name: " + rs.getString("name") +
                                   " | Dept: " + rs.getString("dept") +
                                   " | Salary: " + rs.getDouble("salary"));
            }

            // 7. Close connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
