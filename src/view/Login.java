package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Connect;
import controller.Queries;

import main.ObjectsAndFunctions;
import model.CurrentUser;

public class Login {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	static Connect con = Connect.getConnection();
	static CurrentUser curr;
	public static void loginPage() {
		String email = new String("");
		String password = new String("");
		System.out.println("Input your email and password");
		System.out.println("=============================");
		do {
			System.out.print("Email : ");
			email = scan.nextLine();
			System.out.print("Password : ");
			password = scan.nextLine();
			System.out.println();
		} while (email.trim().equals("")  || password.trim().equals(""));
		try {
			ResultSet checkUsernameAndPassword = Queries.StartQuery("SELECT * "
					+ "FROM MsEmployee ME "
					+ "JOIN MsBranch MB ON "
					+ "MB.BranchID = ME.BranchID JOIN "
					+ "MsLocation ML ON "
					+ "ML.LocationID = MB.LocationID "
					+ "WHERE EmployeeEmail = '" + email + "' AND EmployeePassword = '" + password + "'");
			if(checkUsernameAndPassword.next()) {
				CurrentUser.setUserData(checkUsernameAndPassword.getInt("EmployeeId"), 
						checkUsernameAndPassword.getInt("BranchId"), 
						checkUsernameAndPassword.getString("EmployeeName"),
						checkUsernameAndPassword.getString("BranchName"), 
						checkUsernameAndPassword.getString("Location"), 
						checkUsernameAndPassword.getString("RestaurantType"));
				ObjectsAndFunctions.cls();
				MainMenu.ShowMainMenu();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
