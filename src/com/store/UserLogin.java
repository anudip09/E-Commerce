package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin {
	Scanner scan = new Scanner(System.in);

	public void getLogin() throws SQLException {
		UserConnection userconnection = new UserConnection();
		// Make The Connection
		Connection connection = userconnection.getUserConnection();

		System.out.println("Enter Your User Name");
		String username = scan.nextLine();
		System.out.println("Enter Your Password");
		String password = scan.nextLine();
		// mysql query
		// String sql = ;

		PreparedStatement stm = connection.prepareStatement("select * from user where user_name=? and user_password=?");
		stm.setString(1, username);
		stm.setString(2, password);

		ResultSet rs = stm.executeQuery();

		if (rs.next()) {

			if (rs.getString(2).equals(username) && rs.getString(3).equals(password)) {
				Product product = new Product();
				product.getProductDetails();
				product.getQuantity();
				Cart cart = new Cart();
				cart.addToCart();

			}
		} else {
			System.out.println("Invalid Password Or Username");

		}

		
	}

}
