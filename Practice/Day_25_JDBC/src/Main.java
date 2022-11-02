import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String url, userName, password;
		
		url = "jdbc:mysql://localhost:3306/hammadb";
		userName = "root";
		password = "august2000";
		
		//above jdk 1.6 the below line is not mandatory
		//Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection connect = DriverManager.getConnection(url, userName, password);
		System.out.println("Connection established !");
		System.out.println("DB Metadata: ");
		
		DatabaseMetaData dbm = connect.getMetaData();
		
		System.out.println(dbm.getDatabaseMajorVersion());
		System.out.println(dbm.getDatabaseProductName());
		System.out.println(dbm.getDriverMajorVersion());
		System.out.println(dbm.getDriverName());
		System.out.println(dbm.getConnection().toString());
		System.out.println(dbm.getURL());
		
		
		
		Statement st = connect.createStatement();
		st.execute("SELECT First_Name, Last_Name FROM actor;");
		
		ResultSet rs = st.getResultSet();
		
		ResultSetMetaData rsm = rs.getMetaData();
		
		int i,n = rsm.getColumnCount();
		
		for(i=1;i<=n;++i)
			System.out.println(rsm.getColumnName(i) + " " + rsm.getColumnTypeName(i));
		
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		
		
	}
}
