package com.collections;

public class Student implements Comparable<Student>{
	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.getId() > o.getId())
			return 1;
		else if(this.getId() < o.getId())
			return -1;
		
		return 0;
	}
	
	@Override
	public String toString() {
		return this.getId() + " " + this.getName();
	}
	
}
