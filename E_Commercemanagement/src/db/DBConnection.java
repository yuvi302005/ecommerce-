package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	 private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Manoj@16";

	    public static Connection getConnection() {
	        Connection con = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return con;
	    }
}
