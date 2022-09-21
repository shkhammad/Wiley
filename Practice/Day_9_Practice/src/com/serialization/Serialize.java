package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {
	
	//a common class to implement serialization and deserialization
	public static void serialize(Object obj, String fileName) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		//the writeObject method of the class which wants to achieve
		//serialization is invoked implicitly --> internally, 
		//where it is (kind of) overridden
		oos.writeObject(obj);
		oos.close();
	}
	
	public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//the readObject method of the class which wants to achieve
		//deserialization is invoked implicitly --> internally, 
		//where it is (kind of) overridden
		Object obj = ois.readObject();
		ois.close();
		
		return obj;
	}
	
}
