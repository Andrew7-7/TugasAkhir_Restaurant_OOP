package main;

import java.sql.SQLException;
import java.util.Scanner;

import model.Connect;

public class Main {
	Scanner scan = new Scanner(System.in);
	Connect con = Connect.getConnection();
	public Main() {
		try {
			con.AddMenu("INSERT INTO msbranch(LocationId, BranchName) VALUES (1, 'LaperAh Tanjung Priuk');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		new Main();
	}

}		
