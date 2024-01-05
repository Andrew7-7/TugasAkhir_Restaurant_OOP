package view;

import java.util.Scanner;

import main.ObjectsAndFunctions;
import model.CurrentUser;
import menuController.CheckOrderedMenu;
import menuController.ShowAllOrders;
import controller.MakeOrder;
import controller.UpdateOrder;
import controller.*;

public class MainMenu {
	static Scanner scan = ObjectsAndFunctions.getScanner();
	public static void ShowMainMenu() {
		Integer choices=-1;
		System.out.println(CurrentUser.getBranchName());
		System.out.println("Welcome " + CurrentUser.getEmployeeName());
		System.out.println("1. Make Order");
		System.out.println("2. Update Order");
		System.out.println("3. Start Order");
		System.out.println("4. End Order");
		System.out.println("5. Modify Menu");
		System.out.println("6. Exit");
		System.out.print(">> ");
		try {
			choices = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			scan.nextLine();
		}
		switch (choices) {
		case 1:
			MakeOrder.MakeOrder();
			break;
		case 2:
			UpdateOrder.updateTransactionHeaderPage();
			break;
		case 3:
			StartOrder.StartOrder();
			break;
		case 4:
			EndOrder.EndOrder();
			break;
		case 5:
			ModifyMenu.ModifyMenuPage();
			break;
		default:
			break;
		}
	}
}
