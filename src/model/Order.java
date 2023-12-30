package model;

public class Order {
	private Integer OrderId,EmployeeID;
	private String ReservedTime, ReservedStatus;
	public Order(Integer orderId, Integer employeeID, String reservedTime, String reservedStatus) {
		super();
		OrderId = orderId;
		EmployeeID = employeeID;
		ReservedTime = reservedTime;
		ReservedStatus = reservedStatus;
	}
	public Integer getOrderId() {
		return OrderId;
	}
	public void setOrderId(Integer orderId) {
		OrderId = orderId;
	}
	public Integer getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}
	public String getReservedTime() {
		return ReservedTime;
	}
	public void setReservedTime(String reservedTime) {
		ReservedTime = reservedTime;
	}
	public String getReservedStatus() {
		return ReservedStatus;
	}
	public void setReservedStatus(String reservedStatus) {
		ReservedStatus = reservedStatus;
	}
	
}
