package com.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection2 {
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
			
			//create statement
			Statement st = connection.createStatement();
			String sql = "select * from students";
			ResultSet executeQuery = st.executeQuery(sql);
			while(executeQuery.next()){
				System.out.println("ID:"+executeQuery.getInt("id")+"|name:"+executeQuery.getString("name")+"|Email:"+executeQuery.getString("email"));
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
