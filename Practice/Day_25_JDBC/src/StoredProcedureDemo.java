import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class StoredProcedureDemo {

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
			
			//callable statements are used to execute stored procedures
			String sql = "{CALL calculate_sum_author_age (?)}";
			CallableStatement cs = connect.prepareCall(sql);
			
			cs.registerOutParameter(1, java.sql.Types.INTEGER);
			
			cs.execute();
			System.out.println(cs.getInt(1));
			
			String sql2 = "{CALL add_number(?,?)}";
			CallableStatement cs2 = connect.prepareCall(sql2);
			
			cs2.registerOutParameter(1, java.sql.Types.INTEGER);
			cs2.setInt(1, 5);
			cs2.setInt(2, 12);
			cs2.execute();
			
			System.out.println(cs2.getInt(1));
			
		} 
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
