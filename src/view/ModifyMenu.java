package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.menuController.ShowAllMenu;
import main.ObjectsAndFunctions;
import model.menu.Menu;

public class ModifyMenu {
	public static ArrayList<Menu> menus = new ArrayList<>();
	static Scanner scan = ObjectsAndFunctions.getScanner();
	private static int pick;
	public static void ModifyMenuPage() {
		do {
			
			do {
				pick = -1;
				System.out.println("Modify Menu");
				System.out.println("=====================");
				System.out.println("1. Add Menu");
				System.out.println("2. Update Menu");
				System.out.println("3. Delete Menu");
				System.out.println("4. Back");
				System.out.print(">> ");
				try {
					pick = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
				}
				
			}while(pick<1 || pick>4);
			
			ShowAllMenu.ShowAllMenus();
			if(pick==1) {
				AddMenu.AddMenuPage();
			}else if(pick==2) {
				UpdateMenu.UpdateMenuPage();
			}else if(pick==3) {
				DeleteMenu.DeleteMenuPage();
			}else {
				return;
			}
		}while(pick!=4);
	}

}
