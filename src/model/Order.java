package model;

public class Order {
	private Integer OrderId, EmployeeID, TableTypeID, TableQuantity, TotalPeopleReserved;
	private String ReservedTime, ReservedStatus, CustomerName;
	public Order(Integer orderId, Integer tableTypeID, String reservedTime, Integer employeeID, String customerName, String reservedStatus, Integer tableQuantity, Integer totalPeopleReserved) {
		super();
		OrderId = orderId;
		TableTypeID = tableTypeID;
		ReservedTime = reservedTime;
		EmployeeID = employeeID;
		CustomerName = customerName;
		ReservedStatus = reservedStatus;
		TableQuantity = tableQuantity;
		TotalPeopleReserved = totalPeopleReserved;
	}
	public Integer getTableTypeID() {
		return TableTypeID;
	}
	public void setTableTypeID(Integer tableTypeID) {
		TableTypeID = tableTypeID;
	}
	public Integer getTableQuantity() {
		return TableQuantity;
	}
	public void setTableQuantity(Integer tableQuantity) {
		TableQuantity = tableQuantity;
	}
	public Integer getTotalPeopleReserved() {
		return TotalPeopleReserved;
	}
	public void setTotalPeopleReserved(Integer totalPeopleReserved) {
		TotalPeopleReserved = totalPeopleReserved;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
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
