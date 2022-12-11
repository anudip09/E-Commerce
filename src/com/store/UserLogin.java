package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
	Scanner scan = new Scanner(System.in);

	public  void getLogin() throws SQLException {
		UserConnection userconnection = new UserConnection();
		// Make The Connection
		Connection connection = userconnection.getUserConnection();
		// mysql query
		String sql = "select * from login";

		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		System.out.println("Enter Your User Name");
		String username = scan.nextLine();
		System.out.println("Enter Your Password");
		String password = scan.nextLine();

		while (rs.next()) {

			String name = rs.getString(2);
			String pass = rs.getString(3);

			if (name.equals(username) && pass.equals(password)) {
				System.out.println("Login successful...");
				break;
			} else { 
				System.out.println("Invalid Username Or Password");
				break;
			}  
		}

	} 
	
}
