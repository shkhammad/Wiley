import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class BatchDemo {
	
	public static void main(String[] args) {
		String url,file;
		
		url = "jdbc:mysql://localhost:3306/hammadb";
		//userName = "root";
		//password = "august2000";
		file = "D:/Coding/SQL/properties.txt";
		
		try(FileReader fr = new FileReader(file)) {
			
			//using properties class
			Properties property = new Properties();
			property.load(fr);
			
			Connection connect = DriverManager.getConnection(url, property);
			
			String sql = "INSERT INTO Author (Author_Name, Author_Age) VALUES (?,?)";
			
			PreparedStatement ps = connect.prepareStatement(sql);
			
			//without setting auto-commit to false, queries are executed as 
			//a single transaction, by setting it to false, they are executed 
			//in batch i.e the database would only get updated (changes would be reflected) if all the query
			//passes (no compilation errors) and then we have to explicitly call the commit method
			connect.setAutoCommit(false);
			
			ps.setNString(1, "Taha");
			ps.setInt(2, 89);
			ps.addBatch();
			
			ps.setNString(1, "Nazif");
			ps.setInt(2, 10);
			ps.addBatch();
			
			ps.executeBatch();
			
			connect.commit();
			
		} 
		
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	
				
	}
}
