package com.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConnection {
	
	Connection connection=null;

	public Connection getUserConnection() throws SQLException{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
        return connection;
	}

}
