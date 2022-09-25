package com.dsa;

import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		ConcurrentHashMap<Character,Integer> mp = new ConcurrentHashMap<>();
		
		String s = "hammad";
		
		for(char c: s.toCharArray())
			mp.put(c, mp.getOrDefault(c,0)+1);
		
		
		//concurrent addition in the map is possible while iterating it
		for(char c: mp.keySet()) {
			out.println(c + " " + mp.get(c));
			mp.putIfAbsent('s', 3);
			mp.put('a', 5);
		}
		
		out.println(mp);
		
		
		
		
		
		
		
		
		
		out.close();
	}
}	
