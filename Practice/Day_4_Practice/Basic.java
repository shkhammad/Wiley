import java.io.PrintWriter;

public class Basic {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		
		Color color = Color.BLUE;
		out.println(color);
		out.println(color.getIntensity());
		
		
		Student student1 = new Student("Hammad",80);
		Student student2 = new Student("Priyam",60);
		Student student3 = new Student("Kaivan",70);
		
		out.println(student1.getName());
		out.println(student1.getMarks());
		
		out.println(student2.getName());
		out.println(student2.getMarks());
		
		out.println(student3.getName());
		out.println(student3.getMarks());
		
		out.println(Student.getTotal());
		
		
		out.close();
			
	}
}
