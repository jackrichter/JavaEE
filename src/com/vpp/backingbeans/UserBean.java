package com.vpp.backingbeans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user")		// Need to add the jsf-api.jar (external jar) to "Referenced Libraries" (use Build Path)
public class UserBean
{
	private String name;
	private Date currentDateAndTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCurrentDateAndTime() {
		return currentDateAndTime;
	}

	public void setCurrentDateAndTime(Date currentDateAndTime) {
		this.currentDateAndTime = currentDateAndTime;
	}

	/**
	 * Required (by JSF): 1. Return a String. 2. No parameters.
	 */
	public String greetUser()
	{
		// 1. Do business processing
		currentDateAndTime = new Date();
		
		// 2. Forward to the next page
		return "welcome";
	}
}
