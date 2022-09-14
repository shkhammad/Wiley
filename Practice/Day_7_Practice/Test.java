import java.io.PrintWriter;
import java.util.Scanner;

public class Test {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		//String is immutable in java
		String s1 = "Hammad";
		String s2 = "Shaikh";
		
		//here "Shaikh" object is gone (unreachable)
		s2 = "Bakht";
		
		out.println(s1);
		out.println(s2);
		
		//now "Hammad" is gone
		s1 = s1.toUpperCase();
		out.println(s1);
		
		//in jvm outside pool
		String s3 = new String("Sikandar");
		//in constant string pool
		String s4 = "Sikandar";
		
		if(s3 == s4)
			out.println("Yes");
		
		else
			out.println("No");
		
		//for all strings if the string content is equal 
		//then hashcode will also be equal
		if(s3.hashCode() == s4.hashCode())
			out.println("Yes");
		
		else
			out.println("No");
		
		
		String s5 = "Samina";
		String s6 = "Samina";
		
		s6 = "Samina";
		
		//here == checks the memory reference of both the object
		//since they are not initialized using new operator and a
		//are in the same constant string pool, also
		//have the same content both references will be pointing
		//to the same value, so equal
		if(s5 == s6)
			out.println("Yes");
		
		else
			out.println("No");
		
		if(s5.hashCode() == s6.hashCode())
			out.println("Yes");
		
		else
			out.println("No");
		
		Scanner in = new Scanner(System.in);
		
		//while taking input it instantiates a new object
		//so memory reference would be different and outside string
		//pool
		String s7 = in.next();
		String s8 = in.next();
		
		if(s7 == s8)
			out.println("Yes");
		
		else
			out.println("No");
		
		if(s7.hashCode() == s8.hashCode())
			out.println("Yes");
		
		else
			out.println("No");
		
		
		
		//we can use intern method to force it into the string pool
		//inside the string pool if value/content is same
		//it would be equal
		String s9 = in.next().intern();
		String s10 = in.next().intern();
		
		if(s9 == s10)
			out.println("Yes");
		
		else
			out.println("No");
		
		if(s9.hashCode() == s10.hashCode())
			out.println("Yes");
		
		else
			out.println("No");
		
		
		String s11 = in.next();
		String s12 = in.next();
		
		
		//generally for strings use the equals method for comparing the
		//content of both the strings
		if(s11.equals(s12))
			out.println("Yes");
		
		else
			out.println("No");
		
		if(s11.hashCode() == s12.hashCode())
			out.println("Yes");
		
		else
			out.println("No");
		
		
		in.close();
		out.close();
	}
}
