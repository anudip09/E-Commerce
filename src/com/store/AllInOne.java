package com.store;

import java.sql.SQLException;
import java.util.Scanner;

public class AllInOne {

	public void allInOne() throws SQLException {

		Scanner scan = new Scanner(System.in);

		while (true) {
			
			System.out.println("\t\t\t\t\t\t< < < Welcome To Z Store > > >");
			System.out.println("\t\t\t Press 1 For Registration ");
			System.out.println("\t\t\t Press 2 For Login ");
			System.out.println("\t\t\t Press 3 For Log Out ");
			System.out.println("\t\t\t Press 4 For Admin Login ");
			System.out.println("\t\t\t Press 5 For Get Product List In Ascending Order.");

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
				System.out.println("==============================================================================================================================");
				
				System.out.println("\t\t\t\t\t\t\t\t * * * Thanks For Visting Our Store & Please Visit Again... * * * ");
				
				System.out.println("==============================================================================================================================");
				
				System.exit(0);
				
				break;

				
			case 4:
				
				Admin admin=new Admin();
				admin.getHistory();
				
				break;
				
			case 5:
				
				AscOrder ascorder=new AscOrder();
				ascorder.getAscOrder();
				
				break;

			}

		}

	}

}
