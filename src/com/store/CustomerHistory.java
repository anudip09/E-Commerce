package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerHistory {
	
	public void getCustomerHistory() throws SQLException {
		
		UserConnection userconnection = new UserConnection();
		// Make The Connection
		Connection connection = userconnection.getUserConnection();
		
		String arg1="select from products where product_id=?";
		PreparedStatement pps1=connection.prepareStatement(arg1);
		
		String arg2="select from user where user_id=?";
		PreparedStatement pps2=connection.prepareStatement(arg2);
		
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		
			
			
			
		
	}

}
