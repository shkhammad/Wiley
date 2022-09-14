import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Substitute {
	
	public static void throwException() throws UserDefined{
			throw new UserDefined();
	}
	
	public static void main(String[] args) {
		
		
		//try-with resources
		//don't need to explicitly close the file
		//can be used with every class which implements a closeable interface
		
		try(FileInputStream fis = new FileInputStream(new File("a.txt"))){
			
		}
		
		catch(FileNotFoundException f) {
			System.out.println("File not found on the disk");
		}
		
		catch(IOException i) {
			System.out.println("Cannot close the file");
		}
		
		finally {
			System.out.println("Finally Block");
		}
		
		System.out.println("Hammad");
		
		try {
			throwException();
		}
		
		catch(UserDefined e) {
			e.printStackTrace();
			System.out.println(e);
			System.out.println(e.getMessage());
			System.out.println("Exception Handled !");
		}
		
	}
}
