package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import controller.menuController.ShowAllMenu;
import controller.menuController.ShowAllOrders;
import view.MainMenu;
import view.ModifyMenu;
import main.ObjectsAndFunctions;
import model.CurrentUser;
import model.Order;
import model.menu.Menu;

public class MakeOrder {
	static ArrayList<Menu> menus = ModifyMenu.menus;
	static Scanner scan = ObjectsAndFunctions.getScanner();
	
	public static void MakeOrder() {
		int TotalPeopleReserved = 0, TableTypeID = 0, TableQuantity, MaxLoad = 0;
		String CustomerName;
		do {
			System.out.print("Input customer name: ");
			CustomerName = scan.nextLine();
		}while(CustomerName.equals(""));
		do {
			System.out.print("Input total people reservation: ");
			try {
				TotalPeopleReserved = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
		}while(TotalPeopleReserved <= 0);
		do {
			System.out.println("1. Romantic");
			System.out.println("2. General");
			System.out.println("3. Family");
			System.out.print("Choose table type number: ");
			try {
				TableTypeID = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				scan.nextLine();
			}
			switch(TableTypeID) {
			case 1:
				MaxLoad = 2;
				break;
			case 2:
				MaxLoad = 4;
				break;
			case 3:
				MaxLoad = 10;
				break;
			}
		}while(TableTypeID <= 0 && TableTypeID > 3);
		TableQuantity = TotalPeopleReserved / MaxLoad;
		if(TotalPeopleReserved % MaxLoad != 0) {
			TableQuantity += 1;
		}
		ObjectsAndFunctions.cls();
		
		System.out.printf("|%-15s|%-20s|%-15s|%-25s|\n", "Table Type ID", "Customer Name", "Table Quantity", "Total People Reserved");
		System.out.printf("|%-15d|%-20s|%-15d|%-25d|\n", TableTypeID, CustomerName, TableQuantity, TotalPeopleReserved);
		System.out.println("================================================================================");
		try {
			Queries.UpdateQueries(String.format(
			        "INSERT INTO TransactionDetail (TableTypeID, ReservedTime, EmployeeID, CustomerName, ReservationStatus, TableQuantity, TotalPeopleReserved) " +
			        "VALUES (%d, NOW(), %d, '%s', 'In Reserve', %d, %d);",
			        TableTypeID, CurrentUser.getEmployeeID(), CustomerName, TableQuantity, TotalPeopleReserved));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
