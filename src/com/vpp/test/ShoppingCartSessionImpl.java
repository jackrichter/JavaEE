package com.vpp.test;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class ShoppingCartSessionImpl implements ShoppingCartSession {
	
	private List<String> items;
	
	public ShoppingCartSessionImpl() {
		
		this.items = new ArrayList<String>();
	}
	
	public void addItem(String item) 
	{
		this.items.add(item);
	}
	
	public List<String> getAllItems()
	{
		return this.items;
	}
	
	@Remove			// Crucial to a Stateful bean. Server knows that the bean can be destroyed.
	public void checkout()
	{
		// add items to a database
	}
}
