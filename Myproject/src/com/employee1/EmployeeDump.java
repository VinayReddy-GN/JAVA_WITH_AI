package com.employee1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDump {

    private static final int BATCH_SIZE = 100;

    public static void loadFromFile(String filePath) {

        String sql = "INSERT INTO Employee (emp_name, department, salary, city) VALUES (?,?,?,?)";

        System.out.println("===== STARTING EMPLOYEE DATA INSERT =====");

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                BufferedReader reader = new BufferedReader(new FileReader(filePath))
        ) {

            con.setAutoCommit(false);

            String line;
            int count = 0;
            int total = 0;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty())
                    continue;

                String[] parts = line.split(",");

                if (parts.length != 4)
                    continue;

                ps.setString(1, parts[0].trim()); // name
                ps.setString(2, parts[1].trim()); // department
                ps.setDouble(3, Double.parseDouble(parts[2].trim())); // salary
                ps.setString(4, parts[3].trim()); // city

                ps.addBatch();

                count++;
                total++;

                if (count == BATCH_SIZE) {

                    ps.executeBatch();
                    ps.clearBatch();
                    count = 0;

                    System.out.println(total + " rows inserted...");
                }
            }

            if (count > 0) {
                ps.executeBatch();
                ps.clearBatch();
            }

            con.commit();

            System.out.println("====================================");
            System.out.println("TOTAL ROWS INSERTED : " + total);
            System.out.println("====================================");

        } catch (SQLException e) {

            System.out.println("DATABASE ERROR : " + e.getMessage());
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("FILE ERROR : " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("===== EMPLOYEE BATCH PROCESSING =====");

        String filePath = "employee.csv"; // put file in project root

        loadFromFile(filePath);

        System.out.println("===== PROCESS COMPLETED =====");
    }
}