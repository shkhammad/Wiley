import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
	private int empId;
	private String empName,empDept;
	private double empBasicSalary,empGrossSalary;
	
	public Employee(int empId, String empName, String empDept, double empBasicSalary) {
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.empBasicSalary = empBasicSalary;
	}
	
	public static List<String> searchEmployees(Employee employees[], String empDept){
		
		List<String> names = new ArrayList<String>();
		int i;
		
		for(i=0;i<5;++i) {
			if(employees[i].getEmpDept().equals(empDept))
				names.add(employees[i].getEmpName());
		}
		
		return names;
	}
	
	public static Pair[] sortEmployees(Employee employees[]) {
		
		int i;
		Pair pairs[] = new Pair[5];
		
		for(i=0;i<5;++i) {
			pairs[i] = new Pair(employees[i].getEmpName(), employees[i].getGrossSalary());
		}
		
		Arrays.sort(pairs, new Sort());
	
		return pairs;
	}
	
	@Override
	public boolean equals(Object ob) {
		
		Employee employee = (Employee) ob;
		
		if(this.empId == employee.empId && this.empName.equals(employee.empName))
			return true;
		
		return false;
	}
	
	public double getGrossSalary() {
		this.empGrossSalary = this.empBasicSalary + 0.12 * this.empBasicSalary + 0.08 * this.empBasicSalary;
		return this.empGrossSalary;
	}
	
	public int getEmpId() {
		return this.empId;
	}
	
	
	public String getEmpName() {
		return this.empName;
	}
	
	public String getEmpDept() {
		return this.empDept;
	}
	
	public double getEmpBasicSalary() {
		return this.empBasicSalary;
	}
	
}
