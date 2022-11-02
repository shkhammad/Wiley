import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class Basic {

	public static void main(String[] args) {
		
		String url,file;
		
		url = "jdbc:mysql://localhost:3306/eba";
		//userName = "root";
		//password = "august2000";
		file = "D:/Coding/SQL/properties.txt";
		
		try(FileReader fr = new FileReader(file)) {
			
			//using properties class
			Properties property = new Properties();
			property.load(fr);
			
			Connection connect = DriverManager.getConnection(url, property);
			
			//callable statements are used to execute stored procedures
			
			String sql = "{CALL find_age(?)}";
			CallableStatement cs = connect.prepareCall(sql);
			
			cs.setInt(1, 15);
			cs.execute();
			
			ResultSet rs = cs.getResultSet();
			
			
			while(rs.next())
				System.out.println(rs.getString(1));
			
			String sql2 = "{call average_total_bill(?,?)}";
			CallableStatement cs2 = connect.prepareCall(sql2);
			
			cs2.setString(1, "Industrial");
			cs2.registerOutParameter(2, java.sql.Types.DECIMAL);
			cs2.execute();
			
			System.out.println(cs2.getBigDecimal(2));
			
			
			
		}  
		
		catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
