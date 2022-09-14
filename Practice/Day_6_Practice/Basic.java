import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Basic {
	
	public static void main(String[] args) {
		
		//catching and handling exception
		try {
			execute();
		}
		
		catch(FileNotFoundException fn) {
			System.out.println("File is not present on the disk");
		}
		
		catch(IOException io) {
			System.out.println("Cannot close file");
		}
		
		finally {
			
			int a = 5;
			
			try {
				if(a == 5)
					throw new ArithmeticException();
			}
			
			catch(ArithmeticException ae) {
				System.out.println("Value of variable a is 5 ");
			}
		}
		
		
	}
	
	//add throws declaration in method and catch it in the main method
	public static void execute() throws FileNotFoundException, IOException{
		
		FileInputStream fis = new FileInputStream(new File("a.txt"));
		fis.close();
		
	}
	
}
