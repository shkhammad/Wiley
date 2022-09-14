import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;



public class Test {
	
	public static void main(String[] args) {
		
		//checked
		FileInputStream fis=null;
		
		//try & finally run on different threads concurrently (parallelly)
		try {
			fis = new FileInputStream(new File("abc.txt"));
		} 
		catch (FileNotFoundException e) {
			System.out.println("File is not present on the disk");
			e.printStackTrace();
		}
		
		finally {
			
			try {
				fis.close();
				System.out.println("File Closed !");
			}
			
			//use of generic exception is discouraged
			catch (Exception e) {
				System.out.println(e);
				System.out.println("File cannot be closed");
			}
			
		}
		
		
	}
}
