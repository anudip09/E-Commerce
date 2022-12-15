package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {

	Scanner scan = new Scanner(System.in);
	String username;

	public void getLogin() throws SQLException {
		
		// Make The Object Of UserConnection Class
		UserConnection userconnection = new UserConnection();
		// Make The Connection
		Connection connection = userconnection.getUserConnection();

		System.out.println("Enter Your User Name");

		username = scan.nextLine();

		System.out.println("Enter Your Password");

		String password = scan.nextLine();
	    
		// By Using PrepareStatement
		PreparedStatement stm = connection.prepareStatement("select * from user where user_name=? and user_password=?");

		stm.setString(1, username);
		stm.setString(2, password);

		ResultSet rs = stm.executeQuery();
		

		if (rs.next()) {

			if (rs.getString(2).equals(username) && rs.getString(3).equals(password)) {
				Product product = new Product();
				product.getProductDetails();
				product.getQuantity(username);
				
			}
		} else {
			throw new InvalidInputException(" < < < < < Invalid Username Or Password..... > > > > > ");

		}

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
