package main;

import java.util.Scanner;

public class ObjectsAndFunctions {
	static Scanner scan = new Scanner(System.in);

	public static Scanner getScanner() {
		return scan;
	}
	
	public static void cls() {
		for (int i = 0; i <50; i++) {
			System.out.println();
		}
	}
}
