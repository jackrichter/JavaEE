package com.vpp.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.vpp.staffmanagement.EmployeeManagementServiceRemote;
import com.vpp.staffmanagement.SystemUnavailableException;
import com.vpp.staffmanagement.domain.Employee;

public class ClientApplicationTest {

	public static void main(String[] args) {
		
		try 
		{
			Context jndi = new InitialContext();
			
			/**
			 * ATTENTION: This JNDI lookup string (with concrete implementation class),
			 * works only when there is a SINGLE interface.
			 */
//			EmployeeManagementServiceRemote service = (EmployeeManagementServiceRemote) 
//					jndi.lookup("java:global/EmployeeManagement/EmployeeManagementImplementation");

			EmployeeManagementServiceRemote service = (EmployeeManagementServiceRemote) 
					jndi.lookup("java:global/EmployeeManagement/EmployeeManagementImplementation!com.vpp.staffmanagement.EmployeeManagementServiceRemote");
			
//			ClientApplicationTest.testAddEmployeeNote(service);
//			ClientApplicationTest.testOtherServices(service);
			ClientApplicationTest.testRegisterNewEmployeeWithRollBackForPayroll(service);
		} 
		catch (NamingException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public static void testRegisterNewEmployeeWithRollBackForPayroll(EmployeeManagementServiceRemote service)
	{	
		try
		{
//			service.registerEmployee(new Employee("Richard", "Chesterwood", "Programmer", 15000));
			service.registerEmployee(new Employee("James", "Parsons", "Broadcaster", 5000));
		}
		catch (SystemUnavailableException e)
		{
			System.out.println("Sorry, the payroll system is unavailable. Try again later");
		}
	}
	
	public static void testOtherServices(EmployeeManagementServiceRemote service)
	{	
//		List<Employee> employees = service.getAllEmployees();
		List<Employee> employees = service.searchBySurname("Jones");
		
		for (Employee next : employees) 
		{
			System.out.println(next);
		}
	}
	
	public static void testAddEmployeeNote(EmployeeManagementServiceRemote service)
	{
		service.addEmployeeNote();
	}
}
