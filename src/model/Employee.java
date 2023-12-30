package model;

public class Employee {
	private Integer EmployeeID,BranchID;
	private String EmployeeName,EmployeeEmail,EmployeePassword;
	public Employee(Integer employeeID, Integer branchID, String employeeName, String employeeEmail,
			String employeePassword) {
		super();
		EmployeeID = employeeID;
		BranchID = branchID;
		EmployeeName = employeeName;
		EmployeeEmail = employeeEmail;
		EmployeePassword = employeePassword;
	}
	public Integer getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}
	public Integer getBranchID() {
		return BranchID;
	}
	public void setBranchID(Integer branchID) {
		BranchID = branchID;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}
	public String getEmployeePassword() {
		return EmployeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		EmployeePassword = employeePassword;
	}
	
}
