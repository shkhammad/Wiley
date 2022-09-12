
public class Student {
	private String name;
	private int marks;
	static private int total;
	
	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
		total+=marks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMarks() {
		return this.marks;
	}
	
	public static int getTotal() {
		return total;
	}
	
	static {
		System.out.println("Hi, I am the static block !");
	}
}
