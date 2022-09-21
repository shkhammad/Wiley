package com.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int roll_no;
	
	//for serialization we need to implement the serializable interface
	//suppose we don't have the source code of the Address class and cannot
	//implement serializable and want it to be serialized 
	//and it is the part of the class, then we need to declare the 
	//external class object as transient
	//and implement readObject and writeObject methods of the ObjectOutputStream
	//and ObjectInputStream class 
	transient Address address;
	
	public Student(String name, int roll_no, Address address) {
		this.name = name;
		this.roll_no = roll_no;
		this.address = address;
	}
	
	//kind of overriding the default writeObject method of ObjectOutputStream
	private void writeObject(ObjectOutputStream oos) throws IOException {
		
		oos.defaultWriteObject();
		oos.writeObject(address.getTemporary());
		oos.writeObject(address.getPermanent());
		
	}
	
	//kind of overriding the default readObject method of ObjectInputStream
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		
		ois.defaultReadObject();
		
		//create a new object of the address (external) class and assign it to 
		//the current address object of the student class
		Address address = new Address((String)ois.readObject(), (String)ois.readObject());
		this.address = address;
			
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getRollNo() {
		return this.roll_no;
	}
	
	public Address getAddress() {
		return this.address;
	}
}
