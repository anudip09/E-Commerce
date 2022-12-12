package com.store;

import java.sql.SQLException;
import java.util.Scanner;

public class AllInOne {

	public void allInOne() throws SQLException {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("< < < Welcome To Z Store > > >");
			System.out.println(" Press 1 For Registration ");
			System.out.println(" Press 2 For Login ");
			//System.out.println(" Press 3 For Product List ");
			//System.out.println(" Press 4 For To Check Quantity & Price ");
			//System.out.println(" Press 5 For To Add Product In Cart ");
			System.out.println(" Press 6 For Exit ");

			int choice = scan.nextInt();

			switch (choice) {

			case 1:
				UserInput userinput = new UserInput();
				userinput.recUserInput();

				break;

			case 2:
				UserLogin userlogin = new UserLogin();
				userlogin.getLogin();
				break;
			case 3:
				// Product product=new Product();
				// .getProductDetails();
				break;

			case 4:
				Product productquantity = new Product();
				productquantity.getQuantity();
				break;
			case 5:
				// Cart cart=new Cart();
				// cart.addToCart();
				break;
			case 6:
				System.out.println(" * * * Thanks For Visting Our Store & Please Visit Again... * * * ");
				System.exit(0);

			}

		}

	}

}
