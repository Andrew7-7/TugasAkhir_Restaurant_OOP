package controller;

import java.sql.SQLException;
import java.util.Scanner;

import main.ObjectsAndFunctions;
import menuController.ShowAllOrders;

public class EndOrder {

	static Scanner scan = ObjectsAndFunctions.getScanner();
	public static void EndOrder() {
		ShowAllOrders.inOrder();
		System.out.print("Choose a order ID to finish: ");
		Integer OrderID = scan.nextInt();
		UpdateStatus(OrderID);
	}
	
	public static void UpdateStatus(Integer OrderID) {
		try {
			 Queries.UpdateQueries(
					"UPDATE transactiondetail " +
					"SET ReservationStatus = 'Finalized' " +
					" WHERE OrderID = " + OrderID
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
