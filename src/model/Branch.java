package model;

public class Branch {
	private Integer BranchID;
	public Integer getBranchID() {
		return BranchID;
	}
	public void setBranchID(Integer branchID) {
		BranchID = branchID;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getRestaurantType() {
		return RestaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		RestaurantType = restaurantType;
	}
	private String BranchName,Location,RestaurantType;
	public Branch(Integer branchID, String branchName, String location, String restaurantType) {
		super();
		BranchID = branchID;
		BranchName = branchName;
		Location = location;
		RestaurantType = restaurantType;
	}
}