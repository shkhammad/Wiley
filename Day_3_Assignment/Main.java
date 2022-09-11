import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String ... args) {
		
		Circle circle1 = new Circle(3);
		out.println(circle1.getRadius());
		out.println(circle1.calculateArea());
		
		Circle circle2 = new Circle(7);
		out.println(circle2.getRadius());
		out.println(circle2.calculateArea());
		
		Fibonacci fibonacci = new Fibonacci(13);
		out.println(fibonacci.getRange());
		out.println(Arrays.toString(fibonacci.getSeries()));
		
		Fibonacci fibonacci2 = new Fibonacci(1);
		out.println(fibonacci2.getRange());
		out.println(Arrays.toString(fibonacci2.getSeries()));
		
		Fibonacci fibonacci3 = new Fibonacci(2);
		out.println(fibonacci3.getRange());
		out.println(Arrays.toString(fibonacci3.getSeries()));
		
		
		Date date1 = new Date(20,5,1959);
		
		if(date1.checkDate())
		out.println("Valid");
		else out.println("Invalid");
		
		out.println(date1.displayDate());
		
		Date date2 = new Date(31,12,2023);
		if(date2.checkDate())
			out.println("Valid");
		else out.println("Invalid");
		out.println(date2.displayDate());
		
		
		
		out.close();
	}
}
