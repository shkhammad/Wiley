package com.serialization;

import java.io.IOException;

public class Substitute {
	
	public static void main(String... args) {
		
		Puppy puppy = new Puppy("Fifi",10,"Black");
		
		String fileName = "C:/Users/Shaikh Hammad/OneDrive/Desktop/output.txt";
		
		try {
			Serialize.serialize(puppy, fileName);
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		
		try {
			Puppy puppy2 = (Puppy) Serialize.deserialize(fileName);
			System.out.println(puppy2.getColor() + " " + puppy2.getName() + " " + puppy2.getAge());
		}
		catch(IOException | ClassNotFoundException io) {
			io.printStackTrace();
		}
		
		
		
	}
}
