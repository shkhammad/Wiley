import java.io.PrintWriter;

public class Test {
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		Employee employees[] = new Employee[5];
		
		employees[0] = new Employee(1,"Hammad","IT",600000);
		employees[1] = new Employee(2,"Sikandar","Inventory",400000);
		employees[2] = new Employee(3,"Kaivan","IT",600000);
		employees[3] = new Employee(4,"Gauri","HR",500000);
		employees[4] = new Employee(5,"Samina","Management",400000);
		
		
		for(Employee employee: employees) 
			out.println(employee.getEmpName()+" "+employee.getGrossSalary());
		
		
		out.println(Employee.searchEmployees(employees, "IT"));
		out.println(Employee.searchEmployees(employees, "HR"));
		
		Pair pairs[] = Employee.sortEmployees(employees);
		
		for(Pair val: pairs)
			out.println(val.getName() + " " + val.getSalary());
		
		
		Employee employee1 = new Employee(6,"Samina","Management",400000);
		Employee employee2 = new Employee(6,"Samina","IT",300000);
		
		out.println(employee1.equals(employee2));
		
		
		out.close();
	}
}
