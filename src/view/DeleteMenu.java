package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Queries;
import controller.menuController.CheckOrderedMenu;
import main.ObjectsAndFunctions;
import model.menu.Menu;

public class DeleteMenu {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	public static void DeleteMenuPage() {
		int MenuID = -1;
		boolean check;
		ArrayList<Menu> menus = ModifyMenu.menus;
		do {
			check=false;
			do {
				System.out.print("Pick a MenuID: ");
				try {
					MenuID = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
				}
				for(int i=0;i<menus.size();i++) {
					if(menus.get(i).getMenuID()==MenuID) {
						check=true;
						break;
					}
				}
			}while(check==false);
			check = CheckOrderedMenu.CheckOrderedMenus(MenuID);
			if(check==false) {
				System.out.println("This Menu Cannot Be Deleted");
			}
		}while(check==false);
		
		DeleteMenuData(MenuID);
	}
	
	public static void DeleteMenuData(int MenuID) {
		try {
			 Queries.UpdateQueries(
					"DELETE FROM MsMenu " +
					" WHERE MenuID = " + MenuID
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
