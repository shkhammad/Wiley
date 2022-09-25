package com.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class PropertyDemo {
	
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) {
		
		//internally uses hashtable
		Properties property = new Properties();
		
		property.setProperty("1", "Hammad");
		property.setProperty("2", "Sandipt");
		
		out.println(property);
		
		out.println(property.getProperty("2"));
		
		//read from a file using properties class
		//the file contains key-value mappings
		//key = value
		
		File file = new File("properties.txt");
		
		//write to a file
		try(FileWriter out = new FileWriter(file)) {
			String s = "username = hammad\n";
			out.write(s);
			String s2 = "password = august2000";
			out.write(s2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//read from the file
		//Reads a property list (key and element pairs) from the input character 
		//stream in a simple line-oriented format
		try(FileReader fr = new FileReader(file)) {
			
			Properties property2 = new Properties();
			property2.load(fr);
			out.println(property2.getProperty("username"));
			out.println(property2.getProperty("password"));			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		out.close();
	}
}
