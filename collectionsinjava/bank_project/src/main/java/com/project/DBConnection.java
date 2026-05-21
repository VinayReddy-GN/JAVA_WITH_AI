package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static String url = "jdbc:mysql://localhost:3306/employee1";
    static String user = "root";
    static String password = "Vinay@9105";

    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }
}