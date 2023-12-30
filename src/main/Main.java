package main;

import java.util.Scanner;

import model.CurrentUser;
import view.Login;
import view.Register;

public class Main {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	public Main() {
		int Choice = 0;
		do {
			ObjectsAndFunctions.cls();
			System.out.println("LaperAh RestoManagement");
			System.out.println("=======================");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print(">> ");
			try {
				Choice = scan.nextInt();
				scan.nextLine();
				ObjectsAndFunctions.cls();
				switch (Choice) {
				case 1:
					Login.loginPage();
					break;

				case 2:
					Register.registerPage();
					break;
				}
			} catch (Exception e) {
				scan.nextLine();
			}
			
		} while (Choice != 3);
		
	}
	

	public static void main(String[] args) {
		new Main();
	}

}		
