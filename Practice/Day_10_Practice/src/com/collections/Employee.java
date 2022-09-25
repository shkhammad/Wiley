package com.collections;

public class Employee implements Comparable<Employee>{
	private String name;
	private int id;
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}

	//hashcode method will return the same value if both the objects are equal
	//auto-generated hashcode method based on only id attribute
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		return result;
	}
	
	
	//objects are equal only if their id's are equal
	@Override
	public boolean equals(Object obj) {
		Employee employee = (Employee)obj;
		if(this.getId() == employee.getId())
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return this.getName() + " " + this.getId(); 
	}

	@Override
	public int compareTo(Employee o) {
		return this.getName().compareTo(o.getName());
	}
	
	
	
	
	
	
	
	
	
}
