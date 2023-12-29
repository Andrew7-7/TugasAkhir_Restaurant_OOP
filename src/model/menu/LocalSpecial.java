package model.menu;

public class LocalSpecial extends SpecialMenu{
	private String city;
	
	public LocalSpecial(Integer id,Integer price, String name,String city,String story) {
		super(id,price,name,story);
		this.city = city;
	}

	public synchronized String getCity() {
		return city;
	}

	public synchronized void setCity(String city) {
		this.city = city;
	}
}
