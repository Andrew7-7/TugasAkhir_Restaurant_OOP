package view;

import java.sql.ResultSet;
import java.util.Scanner;

import controller.Queries;
import main.ObjectsAndFunctions;

public class Register {
	public static void registerPage() {
		Scanner scan = ObjectsAndFunctions.getScanner();
		String username,email,password,branchId,branchName;
		System.out.println("Register Your Account");
		System.out.println("=====================");
		do {
			System.out.print("Insert your username	: ");
			username = scan.nextLine();
			System.out.print("Insert your email	: ");
			email = scan.nextLine();
			System.out.print("Insert your password	: ");
			password = scan.nextLine();
			System.out.println();
		} while (email.trim().equals("")  || password.trim().equals("") || username.trim().equals(""));
		try {
			ResultSet checkEmailAvailability = Queries.StartQuery("SELECT EmployeeEmail "
					+ "FROM MsEmployee "
					+ "WHERE EmployeeEmail = '" + email + "'");
			if(checkEmailAvailability.next()) {
				System.out.println("Email Already Used!!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ResultSet displayAllBranches = Queries.StartQuery("SELECT * "
					+ "FROM MsBranch AS B JOIN "
					+ "MsLocation AS ML ON "
					+ "B.LocationID = ML.LocationID");
			System.out.println("Branch Name                   |Location");
			System.out.println("=======================================");
			while(displayAllBranches.next()) {
				System.out.printf("%-30s|%s\n",displayAllBranches.getString("BranchName"),displayAllBranches.getString("Location"));
			}
			System.out.println();
			do {
				System.out.print("Input your branch name : ");
				branchName = scan.nextLine();
				ResultSet checkBranchAvailibility = Queries.StartQuery("SELECT * "
						+ "FROM MsBranch "
						+ "WHERE LOWER(BranchName) = '" + branchName.toLowerCase()  + "'");
				if(checkBranchAvailibility.next()) {
					Queries.UpdateQueries(String.format(
							"INSERT INTO MsEmployee(BranchID, EmployeeName, EmployeeEmail, EmployeePassword) "
							+ "VALUES (%d, '%s','%s', '%s');"
							, checkBranchAvailibility.getInt("BranchID"), username, email, password));
					break;
				}else {
					System.out.println("There are no such branch name");
					branchName = "";
				}
			} while (branchName.trim().equals(""));
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
