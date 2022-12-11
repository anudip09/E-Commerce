package com.store;

import java.sql.SQLException;

public class TestProgram {
	
	public static void main(String[] args) throws SQLException {
		
		UserInput userinput=new UserInput();
		userinput.recUserInput();
		
		UserLogin userlogin=new UserLogin();
		userlogin.getLogin();
		
		Product product=new Product();
		product.getProductDetails();
		product.getQuantity();
		
		Cart cart=new Cart();
		cart.addToCart();
		
		
		}

}
