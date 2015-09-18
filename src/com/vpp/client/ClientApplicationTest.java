package com.vpp.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.vpp.staffmanagement.EmployeeManagementService;
import com.vpp.staffmanagement.domain.Employee;

public class ClientApplicationTest {

	public static void main(String[] args) {
		
		try 
		{
			Context jndi = new InitialContext();
			
			EmployeeManagementService service = (EmployeeManagementService) jndi.lookup("com.vpp.staffmanagement.EmployeeManagementService");
			
			List<Employee> employees = service.getAllEmployees();
			
			for (Employee next : employees) 
			{
				System.out.println(next);
			}
		} 
		catch (NamingException e) {
			
			System.out.println(e);
		}
	}
}
