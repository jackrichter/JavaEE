package com.vpp.staffmanagement;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.vpp.dao.EmployeeDaoImpl;
import com.vpp.staffmanagement.domain.Employee;

@Stateless
public class EmployeeManagementServiceImpl implements EmployeeManagementService {
	
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

	@Override
	public void registerEmployee(Employee newEmployee) {
		
		this.dao.insert(newEmployee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return dao.findAll();
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		
		return dao.findBySurname(surname);
	}
}
