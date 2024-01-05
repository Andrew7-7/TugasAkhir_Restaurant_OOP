package controller.menuController;

import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Queries;
import model.CurrentUser;

public class CheckMenuName {

	public static boolean CheckMenuNames(String MenuName) {
		try {
			ResultSet menuResult = Queries.StartQuery("SELECT *"
					+ "FROM msmenu "
					+ "WHERE AvailableOn = '" + CurrentUser.getBranchName() + "' AND MenuName = '"+ MenuName +"'");
			if(menuResult.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
