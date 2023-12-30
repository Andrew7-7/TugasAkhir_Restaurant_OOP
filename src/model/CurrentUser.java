package model;

public class CurrentUser {
	private static Integer EmployeeID,BranchID;
	private static String EmployeeName,BranchName,Location,RestaurantType;
	public static void setUserData(Integer employeeID, Integer branchID, String employeeName, String branchName, String location, String restaurantType) {
		EmployeeID = employeeID;
		BranchID = branchID;
		EmployeeName = employeeName;
		BranchName = branchName;
		Location = location;
		RestaurantType = restaurantType;
	}
	public static Integer getEmployeeID() {
		return EmployeeID;
	}
	public static void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}
	public static Integer getBranchID() {
		return BranchID;
	}
	public static void setBranchID(Integer branchID) {
		BranchID = branchID;
	}
	public static String getEmployeeName() {
		return EmployeeName;
	}
	public static void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public static String getBranchName() {
		return BranchName;
	}
	public static void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public static String getLocation() {
		return Location;
	}
	public static void setLocation(String location) {
		Location = location;
	}
	public static String getRestaurantType() {
		return RestaurantType;
	}
	public static void setRestaurantType(String restaurantType) {
		RestaurantType = restaurantType;
	}
}
