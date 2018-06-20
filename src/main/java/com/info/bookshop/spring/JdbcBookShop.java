package com.info.bookshop.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class JdbcBookShop implements BookShop {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void purchase(String isbn, Integer userId) {
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			///
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT PRICE FROM BOOK WHERE ISBN =" + isbn);

			int price = 0;
			if (rs != null) {
				while (rs.next()) {
					price = rs.getInt(1);
				}
			}
			System.out.println("price" + price);

			stmt.close();

			///
			Statement stmt2 = conn.createStatement();
			int rs2 = stmt2.executeUpdate("UPDATE BOOK_STOCK SET STOCK = STOCK - 1 WHERE ISBN =" + isbn);
			System.out.println("rs2 is " + rs2);
			stmt2.close();

			/////
			Statement stmt3 = conn.createStatement();
			int rs3 = stmt3
					.executeUpdate("UPDATE ACCOUNT SET BALANCE = BALANCE -1 WHERE USERID ="+userId);
			System.out.println("rs3 is " + rs3);
			stmt3.close();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}
	}

}
