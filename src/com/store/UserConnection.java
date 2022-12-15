package com.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConnection {
	
	Connection connection=null;
 
	public Connection getUserConnection() throws SQLException{
        
		try {
			// Add The Driver 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			// Make The Connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
        return connection;
	}

}
