package menuController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import controller.Queries;
import model.CurrentUser;
import model.Order;
import model.menu.LocalSpecial;
import model.menu.Menu;
import model.menu.SpecialMenu;

public class ShowAllOrders {

	public static ArrayList<Order> orders = new ArrayList<Order>();
	
	public static void inReserve() {
		orders.clear();
		try {
			ResultSet orderResult = Queries.StartQuery("SELECT * "
					+ "FROM transactiondetail "
					+ "WHERE ReservationStatus = 'In Reserve' "
					+ "AND EmployeeID = '" + CurrentUser.getEmployeeID() + "' ");
			while(orderResult.next()) {
				Integer OrderID = orderResult.getInt("OrderID");
				Integer TableTypeID = orderResult.getInt("TableTypeID");
				Date Time = orderResult.getDate("ReservedTime");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String ReservedTime = dateFormat.format(Time);
				Integer EmployeeID = orderResult.getInt("EmployeeID");
				String CustomerName = orderResult.getString("CustomerName");
				String ReservationStatus = orderResult.getString("ReservationStatus");
				Integer TableQuantity = orderResult.getInt("TableQuantity");
				Integer TotalPeopleReserved = orderResult.getInt("TotalPeopleReserved");
				orders.add(new Order(OrderID, TableTypeID, ReservedTime, EmployeeID, CustomerName, ReservationStatus, TableQuantity, TotalPeopleReserved));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.printf("| %-10s | %-30s | %-20s | %-20s | \n", "Order ID", "Employee ID", "Reservation Time", "Reservation Status");
		for(Order order : orders) {
			System.out.printf("| %-10d | %-30s | %-20s | %-20s | \n", order.getOrderId(), order.getEmployeeID(), order.getReservedTime(), order.getReservedStatus());
		}
	}

	public static void inOrder() {
		orders.clear();
		try {
			ResultSet orderResult = Queries.StartQuery("SELECT * "
					+ "FROM transactiondetail "
					+ "WHERE ReservationStatus = 'In Order' "
					+ "AND EmployeeID = '" + CurrentUser.getEmployeeID() + "' ");
			while(orderResult.next()) {
				Integer OrderID = orderResult.getInt("OrderID");
				Integer TableTypeID = orderResult.getInt("TableTypeID");
				Date Time = orderResult.getDate("ReservedTime");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String ReservedTime = dateFormat.format(Time);
				Integer EmployeeID = orderResult.getInt("EmployeeID");
				String CustomerName = orderResult.getString("CustomerName");
				String ReservationStatus = orderResult.getString("ReservationStatus");
				Integer TableQuantity = orderResult.getInt("TableQuantity");
				Integer TotalPeopleReserved = orderResult.getInt("TotalPeopleReserved");
				orders.add(new Order(OrderID, TableTypeID, ReservedTime, EmployeeID, CustomerName, ReservationStatus, TableQuantity, TotalPeopleReserved));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.printf("| %-10s | %-30s | %-20s | %-20s | \n", "Order ID", "Employee ID", "Reservation Time", "Reservation Status");
		for(Order order : orders) {
			System.out.printf("| %-10d | %-30s | %-20s | %-20s | \n", order.getOrderId(), order.getEmployeeID(), order.getReservedTime(), order.getReservedStatus());
		}
	}
}
