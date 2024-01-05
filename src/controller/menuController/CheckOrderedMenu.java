package controller.menuController;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Queries;

public class CheckOrderedMenu {

	public static boolean CheckOrderedMenus(int MenuID) {
		try {
			ResultSet menuResult = Queries.StartQuery("SELECT *"
					+ "FROM TransactionHeader "
					+ "WHERE MenuID = '" + MenuID + "'");
			if(menuResult.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
