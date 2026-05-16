package com.jdbcconnection2;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteEmployee {
	
	private static void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=" + id;
        
        try (Connection conn = DBConnection.getConnection();
                Statement st = conn.createStatement()) {

               int rows = st.executeUpdate(sql);
               System.out.println(rows + " row(s) deleted");

           } catch (Exception e) {
               e.printStackTrace();
           }
       }
	public static void main(String[] args) {
		deleteEmployee(1);
		deleteEmployee(4);
		deleteEmployee(12);
		
	}

}
