import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Demo {
	
	public static void main(String[] args) throws SQLException {
		
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
			
			String sqlInsert = "INSERT INTO Actor (First_Name, Last_Name) VALUES (?, ?)";
			
			PreparedStatement preStat = connect.prepareStatement(sqlInsert);
			
			preStat.setNString(1, "Gauri");
			preStat.setNString(2, "Shukla");
			
			preStat.executeUpdate();
			
			preStat.setNString(1, "Kajal");
			preStat.setNString(2, "Jha");
			
			preStat.executeUpdate();
			
			System.out.println("Record inserted...");
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
		
	}
	
}	
