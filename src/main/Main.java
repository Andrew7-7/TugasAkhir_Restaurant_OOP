package main;

import java.util.Scanner;

import view.login;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	
	public static void cls() {
		for (int i = 0; i <50; i++) {
			System.out.println();
		}
	}
	
	public Main() {
		int Choice = 0;
		do {
			System.out.println("LaperAh RestoManagement");
			System.out.println("=======================");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");
			System.out.print(">> ");
			try {
				Choice = scan.nextInt();
				scan.nextLine();
				switch (Choice) {
				case 1:
					login.loginPage();
					break;

				case 2:
					
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
