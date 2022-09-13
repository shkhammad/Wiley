import java.util.Comparator;

public class Sort implements Comparator <Employee>{
	
	@Override
	public int compare(Employee employee1, Employee employee2) {
		return (int)(employee1.getEmpBasicSalary() - employee2.getEmpBasicSalary());
	}
	
}
