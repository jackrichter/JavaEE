package com.vpp.staffmanagement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.vpp.dao.EmployeeDaoImpl;
import com.vpp.staffmanagement.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementService {
	
	@EJB
	private EmployeeDaoImpl dao;
	
	/**
	 * Not a good solution.
	 * What to do with the exceptions? 
	 * JUnit tests can't have an external service running (JNDI)
	 * 
	 * Use DEPENDENCY INJECTION instead!
	 */
//	public EmployeeManagementServiceImpl() throws NamingException {
//		
//		Context jndi = new InitialContext();
//		this.dao = (EmployeeDao) jndi.lookup("java:global/EmployeeManagement/EmployeeDaoImpl");
//	}

	public void registerEmployee(Employee newEmployee) {
		
		this.dao.insert(newEmployee);
	}

	public List<Employee> getAllEmployees() 
	{
		return dao.findAll();
	}

	public List<Employee> searchBySurname(String surname) {
		
		return dao.findBySurname(surname);
	}
	
	/**
	 * Demonstrates a method that need not be part of the default EJB transactional
	 * behavior (Propagation Rule) if called from outside directly by a client. Calling it from within
	 * the Service, keeps the transactional behavior as long as it's code do not 
	 * communicate with the database (= uses JPA).
	 * 
	 * Use this for "In Memory" operations!
	 */
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public double dummyInMemoryMethod()
	{
		return 109.3838;
	}
}
