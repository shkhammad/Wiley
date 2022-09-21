package com.serialization;
import java.io.Serializable;

public class Dog implements Serializable{
	
	private static final long serialVersionUID = 3L;
	 private String name;
	 private int age;
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public int getAge() {
		return this.age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
}
