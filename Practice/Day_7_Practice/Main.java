import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		String s = "You,are,good,boy";
		String words[] = s.split(",");
		
		for(String word: words)
			out.println(word);
		
		String s2 = "Hammad@gmail.co@m";
		String words2[] = s2.split("[@.]+");
		
		for(String val: words2)
			out.println(val);
		
		
		
		//we pass the delimiter in the constructor
		//to separate the string by words
		//we cannot use regex in stringtokenizer
		StringTokenizer st = new StringTokenizer("It's'kljkj'sqe","'");
		
		while(st.hasMoreTokens()) 
			out.println(st.nextToken());
		
				
		out.close();
	}

}
