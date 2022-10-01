package com.stream;

public class Employee {
	
	private int id,age;
	private String name;
	private char gender;
	
	public Employee(int id, String name, int age, char gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	
	@Override
	public String toString() {
		return this.id + " " + this.name + " " + this.age; 
	}
}
