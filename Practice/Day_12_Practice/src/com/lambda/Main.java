package com.lambda;

import java.io.PrintWriter;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main{
	
	static PrintWriter out = new PrintWriter(System.out);
	

	public static boolean solve(){
		Predicate<String> p = (s) -> {
			//method body
			return s.startsWith("a");
		}; 
		
		return p.test("adam");
	}
	
	public static Predicate<String> helper(){
		
		Predicate<String> predicate = (s) -> {
			
			if(s.equals("Hammad"))
				return true;
			return false;
		};
		
		return predicate;
	}
	
	public static Predicate<String> helper2(){
		return (s) -> {
			
			if(s.equals("Shaikh"))
				return true;
			
			return false;
		};
	}
	
	public static Consumer<String> helper3(){
		return (str) -> out.println(str);
	}
	
	
	public static void main(String[] args) {
		
		Predicate<Integer> p1 = (val) -> {
			//method body	
			if(val == 0)
				return false;
			return true;
		};
		
		out.println(p1.test(3));
		out.println(p1.test(0));
		
		
		Predicate<String> p2 = s -> s.startsWith("ham");
		out.println(p2.test("hammad"));
		
		out.println(Main.solve());
		out.println(helper().test("Hammad"));
		out.println(helper2().test("Shaikh"));
		
		helper3().accept("Hammad");
		
		
		
		
		
		
		
		
		
		
		
		
		
		out.close();
	}
}
