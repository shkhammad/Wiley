import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Test {
	
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
			
			System.out.println("Connection established!!");
			
			Statement st = connect.createStatement();
			st.execute("SELECT Last_Name FROM actor;");
			
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		//above jdk 1.6 the below line is not mandatory
		//Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		
		
		
		
		
	}
}	
