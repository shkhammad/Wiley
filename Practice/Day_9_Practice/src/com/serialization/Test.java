package com.serialization;


import java.io.IOException;

public class Test {
	
	public static void main(String[] args) {
		
		Employee employee = new Employee("Sikandar", 3);
		String fileName = "C:/Users/Shaikh Hammad/OneDrive/Desktop/employee.txt";
		try {
			
			Serialize.serialize(employee,fileName);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			
			Employee employee2 = (Employee)Serialize.deserialize(fileName);
			System.out.println(employee2.getName() + " " +employee2.getId());	
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
