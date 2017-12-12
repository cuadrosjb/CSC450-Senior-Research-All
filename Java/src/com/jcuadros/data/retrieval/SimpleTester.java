package com.jcuadros.data.retrieval;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;
public class SimpleTester {
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			DriverManager.registerDriver(new Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "root");
			st = conn.createStatement();
			for (int i = 1; i < 1000001; i++) {
				st.executeQuery("INSERT INTO researchResults(`id`, `language`, `iteration`, `startTime`) VALUES ( " + i + ", 'Java', " + i + ", Now(6))");
				st.executeQuery("SELECT * FROM sakila.seniorresearch LIMIT " + i);
				st.executeQuery("UPDATE researchResults SET `endTime` = Now(6) WHERE id = " + i);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			try {
				conn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}