package model.menu;

public class Menu {
	private Integer menuID, price;
	private String name;
	public Menu(Integer menuID,Integer price, String name) {
		this.menuID = menuID;
		this.price = price;
		this.name = name;
	}
	public synchronized Integer getId() {
		return menuID;
	}
	public synchronized void setId(Integer id) {
		this.menuID = id;
	}
	public synchronized Integer getPrice() {
		return price;
	}
	public synchronized void setPrice(Integer price) {
		this.price = price;
	}
	public synchronized String getName() {
		return name;
	}
	public synchronized void setName(String name) {
		this.name = name;
	}

}
