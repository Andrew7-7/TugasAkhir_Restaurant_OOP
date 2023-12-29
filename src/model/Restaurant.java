package model;

public class Restaurant {
	private Integer restaurantID;
	private String location,type;
	
	public Restaurant(Integer restaurantID,String location,String type) {
		this.location= location;
		this.restaurantID = restaurantID;
		this.type = type;
	}

	public synchronized Integer getRestaurantID() {
		return restaurantID;
	}

	public synchronized void setRestaurantID(Integer restaurantID) {
		this.restaurantID = restaurantID;
	}

	public synchronized String getLocation() {
		return location;
	}

	public synchronized void setLocation(String location) {
		this.location = location;
	}

	public synchronized String getType() {
		return type;
	}

	public synchronized void setType(String type) {
		this.type = type;
	}
	
	
}