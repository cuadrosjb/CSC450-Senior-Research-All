package com.jcuadros.dbconn;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	public static final String URL = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
	public static final String USER = "root";
	public static final String PASS = "root";

	public static Connection getConnection() {
		try {
			DriverManager.registerDriver(new Driver());
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}
	
}
