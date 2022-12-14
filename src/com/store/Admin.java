package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {

	static String password = "Pass@123";

	public void getHistory() throws SQLException {

		UserConnection userconnection = new UserConnection();
		Connection connection = userconnection.getUserConnection();

		String sql = "SELECT * FROM store.customer_history;";
		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		System.out.println("==============================================================================================================================");
		System.out.println("Enter Admin Password :-> ");
		Scanner scan = new Scanner(System.in);
		String pass = scan.next();
        
		//ArrayList<String> admin=new ArrayList<>();
		
		if (pass.equals(password)) {

			while (rs.next()) {
                
				System.out.println("==============================================================================================================================");
				System.out.println("\t Serial No :-> "+rs.getString(1));
				System.out.println("\t\t\t User Name :-> "+rs.getString(2));
				System.out.println("\t\t\t Product Id :-> "+rs.getString(3));
				System.out.println("\t\t\t\t Product Name :-> "+rs.getString(4));
				System.out.println("\t\t\t\t Product Price :-> "+rs.getString(5));
				System.out.println("\t\t\t\t Product Quantity :-> "+rs.getString(6));
				System.out.println("==============================================================================================================================");
				
				//System.out.println(admin);
				
			}

		} else {
			System.out.println("Enter Valid Password");
		}
	}

}
