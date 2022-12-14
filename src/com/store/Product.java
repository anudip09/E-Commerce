package com.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Product {

	static int amount;
	static int buyQuantity;

	public static void getProductDetails() throws SQLException {

		UserConnection userconnection = new UserConnection();
		Connection connection = userconnection.getUserConnection();

		String sql = "select * from products";
		Statement stm = connection.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		while (rs.next()) {
			System.out.println("==============================================================================================================================");
			System.out.println("\t\t\t\t\t\t\t< < < Product Details > > >");
			System.out.println(" Product ID :-> " + rs.getString(1)); 
			System.out.println(" Product Name :-> " + rs.getString(2));
			System.out.println(" Product Description :-> " + rs.getString(3));
			System.out.println(" Product Quantity :-> " + rs.getString(4));
			System.out.println(" Product Price :-> " + rs.getString(5));
		}
	}

	public static void getQuantity(String name) throws SQLException {

		Scanner scan = new Scanner(System.in);
		UserLogin login = new UserLogin();

		UserConnection userconnection = new UserConnection();
		Connection connection = userconnection.getUserConnection();

		System.out.println("==============================================================================================================================");
		System.out.println("How Many Products You Want....");

		int num = scan.nextInt();
        System.out.println("                                        ");
        System.out.println("==============================================================================================================================");
		
		System.out.println("Check Product Quantity");

		String s = "select product_id,product_name,product_description,product_quantity, product_price from products where product_id=?";

		PreparedStatement pps = connection.prepareStatement(s);

		for (int i = 1; i <= num; i++) {

			System.out.println("Enter Product ID:->> ");

			String id = scan.next();

			pps.setString(1, id);

			ResultSet rs = pps.executeQuery();

			while (rs.next()) {

				System.out.println("Product Id :-> " + rs.getString(1));
				System.out.println("Product Name :-> " + rs.getString(2));
				System.out.println("Product Description :-> " + rs.getString(3));
				System.out.println("Product Quantity :-> " + rs.getString(4));
				System.out.println("Product Price :-> " + rs.getString(5));
                
				System.out.println("==============================================================================================================================");
				
				System.out.println("How Many Product Quantity You Want...");

				int req = scan.nextInt();

				int temp = rs.getInt(5) * req;

				int quantity = rs.getInt(4) - req;
                
				System.out.println("==============================================================================================================================");
				
				System.out.println("Do You Want To Buy The Selected Product??? ");

				String response = scan.next();

				if (response.equalsIgnoreCase("Yes")) {

					amount = amount + temp;
					buyQuantity = buyQuantity + req;

					String update = "update products set product_quantity =? where product_id=?";

					PreparedStatement pps3 = connection.prepareStatement(update);

					pps3.setInt(1, quantity);
					pps3.setString(2, rs.getString(1));
					pps3.executeUpdate();
					System.out.println("Total Amount :->> "+amount);

					String history = "insert into customer_history(user_name,product_id,product_name,product_price,product_quantity) values (?,?,?,?,?)";
					PreparedStatement pps4 = connection.prepareStatement(history);
					pps4.setString(1, name);
					pps4.setString(2, rs.getString(1));
					pps4.setString(3, rs.getString(2));
					pps4.setInt(4, amount);
					pps4.setInt(5, buyQuantity);
					pps4.executeUpdate();
					System.out.println("==============================================================================================================================");
					
				} else {
					System.out.println("Choose Again...");
					Product.getProductDetails();
				}

			}

		}

	}

}
