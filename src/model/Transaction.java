package model;

public class Transaction {
	Integer OrderID, MenuID, MenuQuantity;
	public Transaction(Integer orderID, Integer menuID, Integer menuQuantity) {
		OrderID = orderID;
		MenuID = menuID;
		MenuQuantity = menuQuantity;
	}
	public Integer getOrderID() {
		return OrderID;
	}
	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}
	public Integer getMenuID() {
		return MenuID;
	}
	public void setMenuID(Integer menuID) {
		MenuID = menuID;
	}
	public Integer getMenuQuantity() {
		return MenuQuantity;
	}
	public void setMenuQuantity(Integer menuQuantity) {
		MenuQuantity = menuQuantity;
	}

}
