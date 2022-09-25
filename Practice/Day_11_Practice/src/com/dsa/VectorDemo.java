package com.dsa;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		//vectors are synchronized
		Vector<Integer> v = new Vector<>();
		
		v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		
		out.println(v);
		
		//enumeration interface is just like an iterator used for legacy classes
		//backwards compatibility
		Enumeration<Integer> e = v.elements();
		
		while(e.hasMoreElements()) {
			out.println(e.nextElement());
		}
		
		out.close();
	}
}
