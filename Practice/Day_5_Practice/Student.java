
public class Student implements Cloneable {
	
	
	private String name;
	private int roll_no;
	
	public Student(String name, int roll_no) {
		this.name = name;
		this.roll_no = roll_no;
	}
	
	//copy constructor
	public Student(Student student) {
		this.name = student.getName();
		this.roll_no = student.getRollNo();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRollNo() {
		return this.roll_no;
	}
	
	@Override
	public String toString() {
		return this.name+ " " + this.roll_no;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student student = (Student)obj;
		
		if(this.name == student.name && this.roll_no == student.roll_no)
		return true;
		
		return false;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Student)super.clone();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setRollNo(int roll_no) {
		this.roll_no = roll_no;
	}
	
	public Student clone2() {
		
		Student newStudent = new Student(this.getName(), this.getRollNo());
		return newStudent;
	}
	
	
	public Student getClone() throws CloneNotSupportedException {
		
		System.out.println("Clone Created !!");
		return (Student)this.clone();
		
	}
	
	
}
