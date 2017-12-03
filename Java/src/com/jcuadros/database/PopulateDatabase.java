package com.jcuadros.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PopulateDatabase {

	public static void main(String[] args) {
		Connection conn = null;
		Statement pst = null;
		
		String sql = "INSERT INTO `sakila`.`seniorresearch`(`rental_date`, `inventory_id`, `customer_id`, `return_date`, `staff_id`, `last_update`) VALUES (CURRENT_TIMESTAMP, 367, 130, CURRENT_TIMESTAMP, 2, CURRENT_TIMESTAMP);";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root","root");
			pst = conn.createStatement();
			for(int i= 0 ; i < 10000000 ; i++){
				pst.addBatch(sql);
			}
			
			pst.executeBatch();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error catch");
		}finally {
			try{
				pst.close();
				conn.close();
			}catch (Exception e) {
				System.out.println("finally error");
			}
		}

	}

}
