package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {

	public void addToCart() throws SQLException {

		UserConnection userconnection = new UserConnection();
		Connection connection = userconnection.getUserConnection();
        System.out.println(" **************************** ");
		System.out.println("Add Product To Cart");
		Scanner scan = new Scanner(System.in);
		int count=scan.nextInt();
		for(int i=1;i<=count;i++) {
			
		
		
		String s = "select product_id,product_name,product_description,product_quantity,product_price from products where product_id=?";

		
		System.out.println("Enter Product ID");
		String id = scan.next();

		PreparedStatement pps = connection.prepareStatement(s);

		pps.setString(1, id);
		

		ResultSet rs = pps.executeQuery();
        ArrayList<String> al=new ArrayList();
				while (rs.next()) {
					al.add("Product Id:-> " + rs.getString(1));
					al.add("Product Name:-> " + rs.getString(2));
					al.add("Product Description:-> " + rs.getString(3));
					al.add("Product Quantity:-> " + rs.getString(4));
					al.add("Product Price:-> " + rs.getString(5));
					
					System.out.println(al);
					System.out.println(al.get(4));

			
		}
		}
	}

}
