package com.vpp.backingbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="user")		// Need to add the jsf-api.jar (external jar) to Referenced Libraries
public class UserBean
{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
