package com.jdbcconnection2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertIntoEmployees {
	private static void InsertValues(String name, String dept, double salary) {
		String sql = "INSERT INTO employee (name, dept, salary) VALUES (?, ?, ?)"; 
		
		try(Connection conn = DBConnection.getConnection();
				 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			 pstmt.setString(1, name);
	            pstmt.setString(2, dept);
	            pstmt.setDouble(3, salary);
			int rows = pstmt.executeUpdate();
			System.out.println(rows+"is affected");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		InsertValues("vuig","IT",12345.44);


	}
}
