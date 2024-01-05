package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.Queries;
import controller.menuController.CheckMenuName;
import controller.menuController.CheckOrderedMenu;
import main.ObjectsAndFunctions;
import model.menu.LocalSpecial;
import model.menu.Menu;
import model.menu.SpecialMenu;

public class UpdateMenu {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	public static void UpdateMenuPage() {
		int MenuID = -1,pick, index = 0, NewPrice=0;
		String NewName, NewOrigin, NewDesc;
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
						index=i;
						break;
					}
				}
			}while(check==false);
			check = CheckOrderedMenu.CheckOrderedMenus(MenuID);
			if(check==false) {
				System.out.println("This Menu Cannot Be Updated");
			}
		}while(check==false);
		
		do {
			pick=-1;
			try {
				System.out.println("Which One Do You Want to Update?");
				System.out.println("1. Name");
				System.out.println("2. Price");
				System.out.println("3. Origin Location");
				System.out.println("4. Description");
				pick= scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
			}
		}while(pick<1 || pick>4);
		
		
		
		if(pick==1) {
			do {
				System.out.print("New Name: ");
				NewName = scan.nextLine();				
			}while(NewName.isEmpty());
			check = CheckMenuName.CheckMenuNames(NewName);
			if(check==false) {
				System.out.println("Name Has Already Existed");
				return;
			}
			
			UpdateMenuData(MenuID, "MenuName", NewName);
		}else if(pick==2) {
			do {
				System.out.print("New Price: ");
				try {
					NewPrice = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
				}
			}while(NewPrice==0);
			
			UpdateMenuData(MenuID, "Price", NewPrice);
		}else if(pick==3 && menus.get(index) instanceof LocalSpecial) {
			do {
				System.out.print("New Origin: ");
				NewOrigin = scan.nextLine();
			}while(NewOrigin.isEmpty());
			
			UpdateMenuData(MenuID, "OriginLocation", NewOrigin);
		}else if(pick ==4 && (menus.get(index) instanceof LocalSpecial || menus.get(index) instanceof SpecialMenu)){
			do {
				System.out.println("New Description");
				NewDesc = scan.nextLine();
			}while(NewDesc.isEmpty());
			
			UpdateMenuData(MenuID, "CharacteristicOrDescription", NewDesc);
		}
		
	}

	public static void UpdateMenuData(int MenuID, String ColumnName, String Value) {
		try {
			 Queries.UpdateQueries(
					"UPDATE MsMenu " +
					"SET "+ ColumnName + " = '" + Value + "' "+
					"WHERE MenuID = " + MenuID
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateMenuData(int MenuID, String ColumnName, int Value) {
		try {
			 Queries.UpdateQueries(
					"UPDATE MsMenu " +
					"SET "+ ColumnName + " = " + Value +
					" WHERE MenuID = " + MenuID
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
