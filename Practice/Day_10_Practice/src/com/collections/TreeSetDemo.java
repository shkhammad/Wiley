package com.collections;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		TreeSet<Employee> st = new TreeSet<>(); 
		st.add(new Employee("Hammad",1));
		st.add(new Employee("Sikandar",3));
		st.add(new Employee("Samina",2));
		st.add(new Employee("Mittu",5));
		
		out.println(st);
		
		TreeSet<Student> st2 = new TreeSet<>(); 
		st2.add(new	Student(1,"Hammad"));
		st2.add(new Student(3, "Sikandar"));
		st2.add(new Student(2,"Samina"));
		st2.add(new Student(5,"Mittu"));
		
		out.println(st2);
		
		//headset returns a set of elements strictly less than the given input
		SortedSet<Student> ss = st2.headSet(new Student(3,"Kaivan"));
		out.println(ss);
		
		//headset returns a set of elements strictly less or equal to the 
		//given input
		SortedSet<Student> ss2 = st2.headSet(new Student(3,"Kaivan"), true);
		out.println(ss2);
		
		//returns the first element of the tree set
		Student student = st2.first();
		out.println(student);
		
		//returns the last element of the tree set
		Student student2 = st2.last();
		out.println(student2);
		
		//tailset returns the set of elements greater than or equal to the given input
		SortedSet<Student> ss3 = st2.tailSet(new Student(3,"Kaivan"));
		out.println(ss3);
		
		//tailset returns the set of elements strictly greater than the input
		SortedSet<Student> ss4 = st2.tailSet(new Student(3,"Kaivan"), false);
		out.println(ss4);
		
		
		List<Employee> ls = new ArrayList<>();
		ls.addAll(st);
		out.println(ls);
		
		
		Collections.sort(ls, new Comparator<Employee>(){
			
			@Override
			public int compare(Employee e1, Employee e2) {
				
				if(e1.getId() < e2.getId())
					return -1;
				
				else if(e1.getId() > e2.getId())
					return 1;
				
				return 0;
			}
			
		});
		out.println(ls);
		
		
		Collections.sort(ls, (e1, e2) -> {
				return e1.getName().compareTo(e2.getName());
		});
		out.println(ls);
		
		
		Collections.sort(ls, new Comparator<Employee>(){
			
			@Override
			public int compare(Employee e1, Employee e2) {
				return e2.getName().compareTo(e1.getName());
			}
			
		});
		out.println(ls);
		
		
		
		
		out.close();
		
	}
}
