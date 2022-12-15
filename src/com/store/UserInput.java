package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {

	PreparedStatement prs = null;
	Connection con = null;

	public void insertUserInput(String userName, String userPassword, String userMobileNumber) {
           
		try {
			//Make The Object Of UserConnection Class
			UserConnection userconnection = new UserConnection();
			con = userconnection.getUserConnection();
			// By Using Prepare Statement 
			prs = con.prepareStatement("insert into user(user_name,user_password,user_mobileNumber)values(?,?,?)");
			prs.setString(1, userName);
			prs.setString(2, userPassword);
			prs.setString(3, userMobileNumber);

			int i = prs.executeUpdate();
			System.out.println("Registration Successfully..." + i);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void recUserInput() throws SQLException {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter User Name:>> ");
		String userName = scan.next();
		System.out.println("Enter User Password:>> ");
		String userPassword = scan.next();
		System.out.println("Enter User Mobile Number:>> ");
		String userMobileNumber = scan.next();
        
		// Make The Object Of UserInput Class
		UserInput userinput = new UserInput();
		userinput.insertUserInput(userName, userPassword, userMobileNumber);

	}
}
