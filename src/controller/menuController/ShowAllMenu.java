package controller.menuController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.Queries;
import model.CurrentUser;
import model.menu.LocalSpecial;
import model.menu.Menu;
import model.menu.SpecialMenu;
import view.ModifyMenu;

public class ShowAllMenu {
	static ArrayList<Menu> menus = ModifyMenu.menus;
	public static void ShowAllMenus() {
		menus.clear();
		try {
			ResultSet menuResult = Queries.StartQuery("SELECT *"
					+ "FROM msmenu "
					+ "WHERE AvailableOn = '" + CurrentUser.getBranchName() + "' ");
			while(menuResult.next()) {
				Integer MenuID = menuResult.getInt("MenuID");
				String MenuName = menuResult.getString("MenuName");
				Integer Price = menuResult.getInt("Price");
				String Origin = menuResult.getString("OriginLocation");
				String AvailableOn = menuResult.getString("AvailableOn");
				String Desc = menuResult.getString("CharacteristicOrDescription");
				if(Origin == null && Desc == null) {
					menus.add(new Menu(MenuID, Price, MenuName,AvailableOn ));
				}else if(Origin == null) {
					menus.add(new SpecialMenu(MenuID, Price, MenuName, AvailableOn, Desc));
				}else {
					menus.add(new LocalSpecial(MenuID, Price, MenuName, AvailableOn, Origin, Desc));					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.printf("| %-10s | %-40s | %-10s | %-20s | %-10s \n", "Menu ID", "Menu Name", "Price", "Origin Location", "Description");
		for(int i=0;i<menus.size();i++) {
			if(menus.get(i) instanceof LocalSpecial) {
				LocalSpecial LcMenu = (LocalSpecial) menus.get(i);
				System.out.printf("| %-10s | %-40s | %-10s | %-20s | %-10s \n", LcMenu.getMenuID(), LcMenu.getName(), LcMenu.getPrice(), LcMenu.getOrigin(), LcMenu.getCharacteristic());
			}else if(menus.get(i) instanceof SpecialMenu) {
				SpecialMenu SpMenu = (SpecialMenu) menus.get(i);
				System.out.printf("| %-10s | %-40s | %-10s | %-20s | %-10s \n", SpMenu.getMenuID(), SpMenu.getName(), SpMenu.getPrice(), "", SpMenu.getStory());
			}else{
				Menu menu = menus.get(i);
				System.out.printf("| %-10s | %-40s | %-10s | %-20s | %-10s \n", menu.getMenuID(), menu.getName(), menu.getPrice(), "", "");				
			}
		}
	}

}
