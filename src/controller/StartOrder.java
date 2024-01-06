package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.menuController.*;
import main.ObjectsAndFunctions;
import model.menu.Menu;
import view.MainMenu;
import view.ModifyMenu;

public class StartOrder {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	static ArrayList<Menu> menus = ModifyMenu.menus;
	public static void StartOrder() {
		int Order = -1;
		ShowAllOrders.inReserve();
		System.out.print("Choose a OrderID you want to insert into (-1 to start Order): ");
		Order = scan.nextInt();
		if(Order == -1) {
			start();
		}
		ObjectsAndFunctions.cls();
		ShowAllMenu.ShowAllMenus();
		String pick = null;
		do {
			int chosenMenuID;
			do {
				System.out.print("Choose a menu (enter index for example first menu come out type 1 etc): ");
				try {
					chosenMenuID = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
					chosenMenuID = -1;
				}
			} while (chosenMenuID < 1 || chosenMenuID > menus.size());
			Menu chosenMenu = menus.get(chosenMenuID - 1);
			System.out.printf("Chosen Menu: %d%n", chosenMenu.getMenuID());
			
			int quantity;
			do {
				System.out.print("Enter quantity: ");
				try {
					quantity = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					scan.nextLine();
					quantity = -1;
				}
			} while (quantity < 1);
			
			try {
				Queries.UpdateQueries(String.format(
				        "INSERT INTO TransactionHeader (OrderID, MenuID, MenuQuantity) " +
				        "VALUES (%d, %d, %d);", Order, chosenMenu.getMenuID(), quantity));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.print("Do you want to order another menu (y/n): ");
	        pick = scan.nextLine();
		}while(pick.equals("y"));
		int choose = -1;
		do {
			System.out.println("1. Start Order");
			System.out.println("2. Back to main menu");
			try {
				choose = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			if(choose == 1) {
				start();
			}
			if(choose == 2) {
				MainMenu.ShowMainMenu();
			}
		}while(choose < 1 && choose > 2);
		
	}
	
	public static void start() {
		ShowAllOrders.inReserve();
		System.out.print("Choose a order ID to start: ");
		Integer OrderID = scan.nextInt();
		UpdateStatus(OrderID);
	}
	
	public static void UpdateStatus(Integer OrderID) {
		try {
			 Queries.UpdateQueries(
					"UPDATE transactiondetail " +
					"SET ReservationStatus = 'In Order' " +
					" WHERE OrderID = " + OrderID
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
