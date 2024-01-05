package view;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Queries;
import controller.menuController.CheckMenuName;
import main.ObjectsAndFunctions;
import model.CurrentUser;

public class AddMenu {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	private static int pick=-1,Price=0;
	private static String MenuName,Origin,Desc;
	public static void AddMenuPage() {
		System.out.println("Add Menu");
		System.out.println("===============");
		boolean check= false;
		do {
			check = false;
			System.out.println("Menu Name: ");
			MenuName = scan.nextLine();
			check = CheckMenuName.CheckMenuNames(MenuName);
			if(check==false) {
				System.out.println("Menu has been made before!");
			}
		}while(MenuName.isEmpty() || check==false);
		do {
			System.out.println("Price: ");
			try {
				Price = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
			}
		}while(Price<=0);
		
		boolean status;
		do {
			status=false;
			do {
				System.out.println("Menu Type");
				System.out.println("================");
				System.out.println("1. Normal Menu");
				System.out.println("2. Local Special");
				System.out.println("3. Special Menu");
				try {
					pick=scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
				}
			}while(pick<1 || pick>3);
			if(pick==2 && (CurrentUser.getLocation().equals("Surabaya") || CurrentUser.getLocation().equals("Samarinda") || CurrentUser.getLocation().equals("Padang"))) {
				status=true;
				do {
					System.out.print("Story: ");
					Desc = scan.nextLine();
				}while(Desc.isEmpty());
				do {
					System.out.print("Originated from: ");
					Origin = scan.nextLine();
				}while(Desc.isEmpty());
				InsertLocal(MenuName, Price, CurrentUser.getBranchName(), Origin, Desc);
			}else if(pick==3 && (CurrentUser.getLocation().equals("Bandung") || CurrentUser.getLocation().equals("Jakarta") || CurrentUser.getLocation().equals("Bali"))) {
				status=true;
				do {
					System.out.print("Story: ");
					Desc = scan.nextLine();
				}while(Desc.isEmpty());
				InsertSpecial(MenuName, Price, CurrentUser.getBranchName(), Desc);
			}else if(pick==1){
				status = true;
				InsertMenu(MenuName,Price,CurrentUser.getBranchName());
			}
		}while(status==false);
	}

	public static void InsertMenu(String name,int price, String availableOn) {
		try {
			 Queries.UpdateQueries(
					 "INSERT INTO msmenu(MenuName, Price, AvailableOn) values"
					+ "('"+ name +"','"+ price +"','"+ availableOn +"')"  
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void InsertLocal(String name,int price, String availableOn, String origin, String Desc) {
		try {
			 Queries.UpdateQueries(
					 "INSERT INTO msmenu(MenuName,Price,AvailableOn, OriginLocation, CharacteristicOrDescription) values"
					+ "('"+ name +"','"+ price +"','"+ availableOn +"','"+ origin +"','"+ Desc +"')"  
					 
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void InsertSpecial(String name,int price, String availableOn, String Desc) {
		try {
			 Queries.UpdateQueries(
					 "INSERT INTO msmenu(MenuName,Price,AvailableOn, CharacteristicOrDescription) values"
								+ "('"+ name +"','"+ price +"','"+ availableOn +"','"+ Desc +"')"  
					 
			);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
