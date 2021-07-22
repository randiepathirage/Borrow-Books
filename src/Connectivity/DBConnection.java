package Connectivity;

import java.sql.*;

public class DBConnection {
	public Connection conn;
	
	public Connection getConnection() {
		 
		String dbName = "borrow-books";
		String userName = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);
			return conn;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
		
	}

}
