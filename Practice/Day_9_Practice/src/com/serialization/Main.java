package com.serialization;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		
		Student student1 = new Student("Hammad",40, new Address("Bangalore", "Mumbai"));
		String fileName = "C:/Users/Shaikh Hammad/OneDrive/Desktop/student.txt";
		
		try {
			Serialize.serialize(student1, fileName);
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
		try {
			Student student2 = (Student)Serialize.deserialize(fileName);
			
			System.out.println(student2.getName() + " " + student2.getRollNo() 
			+ " " + student2.getAddress().getTemporary() + " " 
			+ student2.getAddress().getPermanent());
			
		} catch (IOException | ClassNotFoundException e) {	
			e.printStackTrace();
		}
		
	}
}
