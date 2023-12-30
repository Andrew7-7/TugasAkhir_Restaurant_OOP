package model.menu;

public class LocalSpecial extends Menu{
	private String Origin, Characteristic;
	public LocalSpecial(Integer menuID, Integer price, String name, String availableOn, String origin,
			String characteristic) {
		super(menuID, price, name, availableOn);
		Origin = origin;
		Characteristic = characteristic;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getCharacteristic() {
		return Characteristic;
	}
	public void setCharacteristic(String characteristic) {
		Characteristic = characteristic;
	}
	
}
