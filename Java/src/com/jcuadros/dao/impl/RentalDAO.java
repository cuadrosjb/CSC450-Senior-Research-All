package com.jcuadros.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcuadros.dbconn.MyConnection;
import com.jcuadros.pojo.Rental;
import com.jcuadros.pojo.RentalDAOI;

public class RentalDAO implements RentalDAOI {

	private final static String QUERY = "SELECT * FROM sakila.seniorresearch LIMIT ";
	private List<Rental> rentals;

	public RentalDAO() {
		rentals = new ArrayList<Rental>();
	}

	@Override
	public List<Rental> getRentals() {

		Rental rental;
		ResultSet rs = null;
		Statement stm = null;
		Connection conn = null;

		try {
			conn = MyConnection.getConnection();

			stm = conn.createStatement();

			for (int i = 1; i < 1000001; i++) {
				saveStartTime(i, stm);
				stm.executeQuery(QUERY + i + ";");
				saveEndTime(i, stm);
			}

			System.out.println("-----------------------------------------");
			
			rs = stm.executeQuery(QUERY + 10 + ";");

			while (rs.next()) {
				rental = new Rental();
				rental.setCustomer_id(rs.getInt("customer_id"));
				rental.setInventory_id(rs.getInt("inventory_id"));
				rental.setLast_update(rs.getTimestamp("last_update"));
				rental.setRental_date(rs.getTime("rental_date"));
				rental.setRental_id(rs.getInt("rental_id"));
				rental.setReturn_date(rs.getTime("return_date"));
				rental.setStaff_id(rs.getInt("staff_id"));
				rentals.add(rental);
			}

		} catch (Exception e) {
			System.out.println("Error...!");
			e.printStackTrace();

		} finally {
			try {
				rs.close();
				stm.close();
				conn.close();
			} catch (Exception e) {
				System.out.println("error 123");
			}
		}

		return rentals;
	}

	public void saveStartTime(Integer idx, Statement stm) {

		String saveStart = "INSERT INTO researchResults(`id`, `language`, `iteration`, `startTime`) VALUES ( " + idx
				+ ", 'Java', " + idx + ", Now(6))";
		try {
			stm.execute(saveStart);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveEndTime(Integer idx, Statement stm) {

		String saveEnd = "UPDATE researchResults SET `endTime` = Now(6) WHERE id = " + idx;
		try {
			stm.execute(saveEnd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
