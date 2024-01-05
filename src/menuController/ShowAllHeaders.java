package menuController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Queries;
import model.CurrentUser;
import model.Transaction;

public class ShowAllHeaders {
	public static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	public static void ShowAllHeaders() {
		transactions.clear();
		try {
			ResultSet transactionResult = Queries.StartQuery("SELECT td.OrderID, MenuID, MenuQuantity " 
		+ "FROM transactiondetail td "
		+ "JOIN transactionheader th ON th.OrderID = td.OrderID "
		+ "WHERE EmployeeID = '" + CurrentUser.getEmployeeID() + "' "
					);
		while(transactionResult.next()) {
			Integer OrderID = transactionResult.getInt("OrderID");
			Integer MenuID = transactionResult.getInt("MenuID");
			Integer MenuQuantity = transactionResult.getInt("MenuQuantity");
			transactions.add(new Transaction(OrderID, MenuID, MenuQuantity));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.printf("| %-10s | %-10s | %-15s |\n", "Order ID", "Menu ID", "Menu Quantity");
		for(Transaction transaction : transactions)
		System.out.printf("| %-10d | %-10d | %-15d |\n", transaction.getOrderID(), transaction.getMenuID(), transaction.getMenuQuantity());
	}

}
