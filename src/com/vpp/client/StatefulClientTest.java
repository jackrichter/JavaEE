package com.vpp.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.vpp.test.ShoppingCartSession;

public class StatefulClientTest {

	public static void main(String[] args) {
		
		try 
		{
			Context jndi = new InitialContext();
			
			ShoppingCartSession cart = (ShoppingCartSession) jndi.lookup("java:global/EmployeeManagement/ShoppingCartSessionImpl");
			
			cart.addItem("Tennis Racquet");
			cart.addItem("Toaster");
			cart.addItem("Some books");
			
			List<String> items = cart.getAllItems();
			
			for (String next : items)
			{
				System.out.println(next);
			}
			
			/**
			 * Don't forget!
			 * Crucial to Stateful EJBs to call the method annotated with @Remove
			 */
			cart.checkout();
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
