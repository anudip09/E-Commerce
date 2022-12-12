package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Product {

	public void getProductDetails() throws SQLException {

		UserConnection userconnection = new UserConnection();
		Connection connection = userconnection.getUserConnection();

		String sql = "select * from products";
		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {

			System.out.println("< < < Product Details > > >");
			System.out.println("Product ID :-> " + rs.getString(1));
			System.out.println("Product Name :-> " + rs.getString(2));
			System.out.println("Product Description :-> " + rs.getString(3));
			System.out.println("Product Quantity :-> " + rs.getString(4));
			System.out.println("Product Price :-> " + rs.getString(5));
		}
	}

	public void getQuantity() throws SQLException {
        
		Scanner scan = new Scanner(System.in);
		
		UserConnection userconnection = new UserConnection();
		Connection connection = userconnection.getUserConnection();
        
		System.out.println(" ********************* ");
		System.out.println("How Many Products You Want....");
        int num=scan.nextInt();
        
		System.out.println("Check Product Quantity");
        
		String s = "select product_id,product_name,product_description,product_quantity from products where product_id=?";
		PreparedStatement pps = connection.prepareStatement(s);

		for(int i=1;i<=num;i++) {
        	 
         
		
		System.out.println("Enter Product ID:->> ");
		String id = scan.next();

		
		pps.setString(1, id);

		ResultSet rs = pps.executeQuery();
        
		while (rs.next()) {

			System.out.println("Product Id :-> " + rs.getString(1));
			System.out.println("Product Name :-> " + rs.getString(2));
			System.out.println("Product Description :-> " + rs.getString(3));
			System.out.println("Product Quantity :-> " + rs.getString(4));
		}
		}
		
	   
	}
	
	

}
