package getConnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnect {
	
	public static Connection getConnection() {
		Connection connect = null;
		
		String url ="jdbc:mysql://localhost/";
		String database = "blog";
		String user ="root";
		String password ="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(url+database,user, password);
			System.out.println("Connection ok !");
			
		} catch (Exception e) {
		System.out.println("erreur connection !!");
		e.printStackTrace();
		}
		return connect;
	}

}
