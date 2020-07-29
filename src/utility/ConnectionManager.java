package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
	public static Properties loadPropertiesFile() throws Exception {
	Properties prop = new Properties();
	InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
	prop.load(in);
	in.close();
	return prop; 
	} 
	
	 public static Connection getConnection() throws Exception {
		 String driver;
		 String url;
		 String username;
		 String password;
		 Properties newprop = new Properties();
		 newprop=loadPropertiesFile();
		 driver=newprop.getProperty("driver");
		 url=newprop.getProperty("url");
		 username=newprop.getProperty("username");
		 password=newprop.getProperty("password");
		 
		 try {
			 Class.forName(driver);
			 Connection con=DriverManager.getConnection(url,username,password);
			 if(con!=null) {
				 System.out.println("Connection established");
			 }
		 }
		 catch (Exception e) {
			 System.out.println("Check your connection");
			System.out.println(e.getMessage());
		}
		 return null;
	 }
}




















