package controller;

import java.sql.SQLException;
import java.util.Scanner;

import main.ObjectsAndFunctions;
import menuController.*;

public class StartOrder {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	public static void StartOrder() {
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
