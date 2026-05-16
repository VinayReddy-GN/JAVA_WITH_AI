package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection1 {
	public static void main(String[] args) {
		//load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2.
			String url = "jdbc:mysql://localhost:3306/college_db";
			String user = "root";
			String password = "Vinay@9105";
			Connection connection = DriverManager.getConnection(url,user,password);
			
			System.out.println("Connection succefull!!");
			System.out.println(connection.getCatalog());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
