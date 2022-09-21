package com.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Puppy extends Dog implements Serializable{
	
	//example of serialization with inheritance
	//subclass can consider (access) superclass attributes for serialization process
	//kind of --> superclass also becomes serializable
	private static final long serialVersionUID = 2L;
	
	private String color;
	
	public Puppy(String name, int age, String color) {
		super(name,age);
		this.color = color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	//kind of overriding the default writeObject method of ObjectOutputStream
	private void writeObject(ObjectOutputStream oos) throws IOException {
		
		//it writes the non-static & non-transient fields of the current class
		//to the stream
		oos.defaultWriteObject();
		
		//for writing attributes of the parent class
		//writeObject is used for writing objects to the stream
		//here we used it with String type as String is a class in java 
		oos.writeObject(getName());
		oos.writeInt(getAge());
		
	}
	
	//kind of overriding the default readObject method of ObjectInputStream
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		//Read the non-static & non-transient fields of the current class 
		//from the stream
		ois.defaultReadObject();
		
		//for reading attributes of the parent class 
		//readObject is used for reading the String object from the stream
		setName((String)ois.readObject());
		setAge(ois.readInt());
		
	}
	
}
