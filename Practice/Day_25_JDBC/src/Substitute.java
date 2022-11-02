import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Substitute {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
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
			
			String sql = "SELECT Age FROM Friend WHERE Friend_Name = ?";
			String sql2 = "INSERT INTO Friend (FriendID, Friend_Name, Age) VALUES (?,?,?)";
			
			PreparedStatement prestat = connect.prepareStatement(sql);
			String name = in.next();
			prestat.setNString(1, name);
			prestat.execute();
			
			ResultSet rs = prestat.getResultSet();
			
			if(rs.first()) {	
				do
					System.out.println(rs.getInt(1));
				while(rs.next());
			}	
			
			
			else {
				PreparedStatement prestat2 = connect.prepareStatement(sql2);
				int id = in.nextInt();
				prestat2.setInt(1, id);
				prestat2.setNString(2, name);
				int age = in.nextInt();
				prestat2.setInt(3, age);
				
				prestat2.execute();
				
				System.out.println("Successful ...");
				
			}
			
			
		}
		
		 catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
