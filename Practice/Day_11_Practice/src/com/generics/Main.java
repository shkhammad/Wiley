package com.generics;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		Generic<String> g = new Generic<>();
		g.add("Hammad");
		out.println(g.print());
		
		Generic<Integer> g2 = new Generic<>();
		g2.add(5);
		out.println(g2.print());
		
		Generic<Double> g3 = new Generic<>();
		g3.add(3.14159);
		out.println(g3.print());
		
		Generic2<Character,Integer> mp1 = new Generic2<>();
		mp1.put('a', 3);
		out.println(mp1.getKey());
		out.println(mp1.getValue());
		
		Generic2<Character,Integer> mp2 = new Generic2<>();
		mp2.put('b', 2);
		out.println(mp2.getKey());
		out.println(mp2.getValue());
		
		Generic2<Character,Integer> mp3 = new Generic2<>();
		mp3.put('c', 1);
		out.println(mp3.getKey());
		out.println(mp3.getValue());
		
		Generic3<Integer> g4 = new Generic3<>(5);
		out.println(g4.getValue());
		
		Generic3<Double> g5 = new Generic3<>(2.5);
		out.println(g5.getValue());
		
		//the below line fails
		//since String class is not a sub-type of class Number
		//Generic3<String> g6 = new Generic3<>("Hammad");
		//out.println(g5.getValue());
		
		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);
		
		solve(ls);
		
		List<Double> ls2 = new ArrayList<>();
		ls2.add(1.5);
		ls2.add(2.5);
		ls2.add(3.5);
		ls2.add(4.5);
		
		solve(ls2);
		
		List<Integer> ls3 = new ArrayList<>();
		ls3.add(1);
		ls3.add(2);
		ls3.add(3);
		ls3.add(4);
		
		solve2(ls3);
		
		List<Object> ls4 = new ArrayList<>();
		ls4.add(1.5);
		ls4.add(2.3);
		ls4.add(3.7);
		ls4.add(4.9);
		
		solve2(ls4);
		
		
		method(3);
		method(2.5);
		method("Hammad");
		
		out.close();
	}
	
	
	//generic methods 
	public static <T> void method(T type) {
		out.println(type);
	}
	
	
	//upper (all super-types are) bounded wildcard
	public static void solve(List<? extends Number> ls) {
		
		for(Number val: ls)
			out.println(val);
		
	}
	
	//lower (all sub-types are) bounded wildcard
	public static void solve2(List<? super Integer> ls) {
		
		for(Object val: ls)
			out.println(val);
		
	}
	
	
	
	
	
}
