package com.sba.wells.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	

	public static  String jdbcURL = "jdbc:mysql://localhost:3306/CoronaKits";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "root";
	private static Connection jdbcConnection;
	
	public static Connection connect() throws SQLException {
		
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
		return jdbcConnection;
	}

	protected static void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
}
