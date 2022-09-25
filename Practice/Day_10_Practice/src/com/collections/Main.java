package com.collections;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;



public class Main {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		//we cannot modify the list (immutable)
		List<Integer> ls = Arrays.asList(1,2,3);
	
		//the below line will result into an exception
		//ls.add(5);
		
		//better way of using the asList method --> assign it to an ArrayList instead
		ArrayList<Integer> ls2 = new ArrayList<>(Arrays.asList(1,2,3));
		ls2.add(4);
		//implicitly ls2.toString() gets invoked
		out.println(ls2);
		
		List<Integer> ls3 = new ArrayList<>();
		
		ls3.add(1);
		ls3.add(2);
		ls3.add(3);
		ls3.add(4);
		
		//iterator method returns an iterator of the same type as of the data-structure
		Iterator<Integer> it1 = ls3.iterator();
		
		while(it1.hasNext()) 
			out.println(it1.next());
		
		//insertion (addition) and deletion is faster in linkedlist as compared
		//to arraylist
		//iteration and retrieval is faster in arraylist as compared
		//to linkedlist
		
		List<Employee> lls = new LinkedList<>();
		
		lls.add(new Employee("Hammad", 1));
		lls.add(new Employee("Samina", 2));
		lls.add(new Employee("Sikandar", 3));
		lls.add(new Employee("Mittu", 4));
		
		Iterator<Employee> it2 = lls.iterator();
		
		//while it has more elements
		while(it2.hasNext()) { 
			Employee employee = it2.next();
			out.println(employee.getName() + " " + employee.getId());
		}
		
		if(lls.get(0).equals(new Employee("Hammad",1)))
			out.println("Yes");
		
		else
			out.println("No");
		
		//listIterator returns an proper iterator which can traverse in both directions
		ListIterator<Employee> lis = lls.listIterator();
		
		out.println("In forward direction:");
		
		while(lis.hasNext()) { 
			Employee employee = lis.next();
			out.println(employee.getName() + " " + employee.getId());
		}
		
		out.println("In backward direction:");
		
		while(lis.hasPrevious()) {
			Employee employee = lis.previous();
			out.println(employee.getName() + " " + employee.getId());
		}
		
		
		List<List<Integer>> rls = new ArrayList<>();
		
		List<Integer> ls4 = new ArrayList<>();
	
		ls4.add(1);
		ls4.add(2);
		ls4.add(3);
		ls4.add(4);
		
		rls.add(ls4);
		out.println(rls.toString());
		
		List<List<Integer>> rls2 = new ArrayList<>();
		rls2.addAll(rls);
		
		out.println(rls2.toString());
		
		out.close();
	}
}
