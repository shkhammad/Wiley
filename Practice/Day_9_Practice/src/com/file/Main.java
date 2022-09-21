package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		//File Handling in Java
		//Byte (Streams) - Hierarchy - FileOutputStream, FileInputStream
		
		//create a file
		//a new file is created in the projects folder
		File file = new File("a.txt");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//write to a file
		try(FileOutputStream fos = new FileOutputStream(file)) {
			
			byte b[] = "Hammad is a good boy".getBytes();
			fos.write(b);
			
		}catch(IOException io) {
			io.printStackTrace();
		}
		
		//read from a file
		try(FileInputStream fis = new FileInputStream(file)) {
			int a;
			while((a=fis.read()) != -1) {
				//ascii value(integer) to char
				System.out.print((char)a);
			}
			
			
		}catch(IOException io) {
			io.printStackTrace();
		}
			
		
	}

}
