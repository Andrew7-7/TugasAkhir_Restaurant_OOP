package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Queries {
	static Connect con = Connect.getConnection();
	public static ResultSet StartQuery(String query) throws SQLException{
		return con.state.executeQuery(query);
	}
	
	public static void UpdateQueries(String query) throws SQLException {
		con.state.executeUpdate(query);
	}
}
