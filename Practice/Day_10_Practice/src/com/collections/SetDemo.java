package com.collections;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		Set<Employee> st = new HashSet<>();
		st.add(new Employee("Hammad",1));
		st.add(new Employee("Sikandar",2));
		st.add(new Employee("Samina",3));
		st.add(new Employee("Mittu",4));
		
		//hashset internally calls equals method and hashcode method as well
		//for maintaining unique hashset of user-defined objects we need to mandatory
		//override equals and hashcode methods in our user-defined class
		//if two objects are equal according to equals() method their hashcode 
		//must be same
		st.add(new Employee("Kaivan",4));
		
		
		//unordered-set output
		for(Employee employee: st) 
			out.println(employee.getName() + " " + employee.getId());
		
		
				
		out.close();
			
	}
}
