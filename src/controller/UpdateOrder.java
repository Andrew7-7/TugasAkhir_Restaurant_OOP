package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import controller.menuController.*;
import main.ObjectsAndFunctions;

public class UpdateOrder {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	public static void updateTransactionHeaderPage() {
		ShowAllHeaders.ShowAllHeaders();
        int orderID;
        int menuID;
        int newMenuQuantity;

        System.out.print("Enter OrderID: ");
        orderID = scan.nextInt();
        scan.nextLine();
        
        System.out.print("Enter MenuID: ");
        menuID = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter new Menu Quantity: ");
        newMenuQuantity = scan.nextInt();
        scan.nextLine();

        updateTransactionHeader(orderID, menuID, newMenuQuantity);
    }

	public static void updateTransactionHeader(int orderID, int menuID, int newMenuQuantity) {
	    try {
	        if (isInReservation(orderID)) {
	            Queries.UpdateQueries(
	                "UPDATE TransactionHeader " +
	                "SET MenuQuantity = " + newMenuQuantity +
	                " WHERE OrderID = " + orderID +
	                " AND MenuID = " + menuID
	            );
	            System.out.println("Order updated successfully.");
	        } else {
	            System.out.println("Cannot update order.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static boolean isInReservation(int orderID) throws SQLException {
	    // Check if the ReservationStatus is "In Reservation" in TransactionDetail
	    String query = "SELECT ReservationStatus FROM TransactionDetail " +
	                   "WHERE OrderID = " + orderID;

	    try (ResultSet resultSet = Queries.StartQuery(query)) {
	        if (resultSet.next()) {
	            String reservationStatus = resultSet.getString("ReservationStatus");
	            return "In Reservation".equals(reservationStatus);
	        }
	        return false;  // OrderID not found
	    }
	}

}
