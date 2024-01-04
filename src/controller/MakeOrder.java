package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Order;
import menuController.ShowAllOrders;

public class MakeOrder {
	ArrayList<Order> orders = ShowAllOrders.orders;
	
	public MakeOrder() {
		orders.clear();
		try {
			ResultSet checkOrder = Queries.StartQuery("SELECT * "
					+ "FROM transactionheader ");
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
