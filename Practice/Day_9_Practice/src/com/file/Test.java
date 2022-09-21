package com.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	
	public static void main(String[] args) {
		
		//Character - Hierarchy - FileWriter, FileReader
		//create a file
		File file = new File("b.txt");
		
		//write to a file
		try(FileWriter out = new FileWriter(file)) {
			String s = "Kaivan is a bad boy";
			out.write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//read from a file
		try(FileReader in = new FileReader(file)) {
			
			//int a;
			BufferedReader br = new BufferedReader(in);
			
			//can also read the file character by character or line by line
			//while((a = br.read()) != -1)
			System.out.print(br.readLine());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
