package view;

import java.util.Scanner;

import main.ObjectsAndFunctions;
import model.CurrentUser;

public class MainMenu {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	static void ShowMainMenu() {
		Integer choices;
		System.out.println(CurrentUser.getBranchName());
		System.out.println("Welcome " + CurrentUser.getEmployeeName());
		System.out.println("1. Make Order");
		System.out.println("2. End Order");
		System.out.println("3. Modify Menu");
		System.out.println("4. Exit");
		choices = scan.nextInt();
		switch (choices) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
			break;
		}
	}
}