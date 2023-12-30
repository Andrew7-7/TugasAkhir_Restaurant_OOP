package model.menu;

public class Menu {
	private Integer MenuID, Price;
	private String Name, AvailableOn;
	public Menu(Integer menuID, Integer price, String name, String availableOn) {
		super();
		MenuID = menuID;
		Price = price;
		Name = name;
		AvailableOn = availableOn;
	}
	public Integer getMenuID() {
		return MenuID;
	}
	public void setMenuID(Integer menuID) {
		MenuID = menuID;
	}
	public Integer getPrice() {
		return Price;
	}
	public void setPrice(Integer price) {
		Price = price;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAvailableOn() {
		return AvailableOn;
	}
	public void setAvailableOn(String availableOn) {
		AvailableOn = availableOn;
	}
}
