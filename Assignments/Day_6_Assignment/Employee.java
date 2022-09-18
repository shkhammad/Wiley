
public class Employee {
	private int empId;
	private String empName;
	private Address empAddress[];
	
	public Employee(int empId, String empName, Address empAddress[]) {
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	public int getEmpId() {
		return this.empId;
	}
	
	public String getEmpName() {
		return this.empName;
	}
	
	public Address[] getEmpAddress() {
		return this.empAddress;
	}
}
