package com.neo.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	
	public static Connection getDbConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;
		try {
		       con = DriverManager.getConnection("jdbc:mysql://localhost/dbtest","root","@ny.1234");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.getMessage();
		}
		return con;
	}

}
