package employee;

public class Employee {
	private Integer employeeID;
	private String employeeName,restaurantLocation;
	public Employee(Integer employeeID, String employeeName,String restaurantLocation) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.restaurantLocation = restaurantLocation;
	}
	public synchronized Integer getEmployeeID() {
		return employeeID;
	}
	public synchronized void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public synchronized String getEmployeeName() {
		return employeeName;
	}
	public synchronized void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public synchronized String getRestaurantLocation() {
		return restaurantLocation;
	}
	public synchronized void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}

}
