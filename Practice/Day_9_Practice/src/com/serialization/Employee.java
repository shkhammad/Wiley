package com.serialization;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	
	//transient keyword is used if we don't want that attribute to be a part of 
	//serialization process
	//default value of datatype would be returned --> 0,null...
	/*transient*/ private int id;
	
	//static variables are also not serialized, since they are related to class
	//and not object --> private static int salary;
	
	
	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
		//Employee.salary = salary;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	
	
}
