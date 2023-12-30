package controller;

import java.sql.*;

public class Connect {
	private final String Username = "root";
	private final String Password = "";
	private final String Database = "restomanagement";
	private final String host = "localhost:3306";
	private final String Connect = String.format("jdbc:mysql://%s/%s",host,Database);
	
	Connection Connect1;
	public Statement state;
	ResultSet Result;
	
	private static Connect SingleConnect;
	
	public static Connect getConnection() {
		if(SingleConnect == null) {
			SingleConnect = new Connect();
		}
		return SingleConnect;
	}
	
	private Connect() {
		try {
			Connect1 = DriverManager.getConnection(Connect,Username,Password);
			state = Connect1.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
