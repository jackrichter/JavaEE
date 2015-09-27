package com.vpp.staffmanagement;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.vpp.dao.EmployeeDaoImpl;
import com.vpp.staffmanagement.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementServiceRemote, EmployeeManagementServiceLocal {
	
	@EJB
	private EmployeeDaoImpl dao;
	
	@EJB
	private ExternalPayrollSystem payrollSystem;
	
	@Resource
	private SessionContext serverCtx;		// This object enables access to theServer
	
	/**
	 * Not a good solution.
	 * What to do with the exceptions? 
	 * JUnit tests can't have an external service running (JNDI)
	 * 
	 * Use DEPENDENCY INJECTION instead!
	 * @throws SystemUnavailableException 
	 */
//	public EmployeeManagementServiceImpl() throws NamingException {
//		
//		Context jndi = new InitialContext();
//		this.dao = (EmployeeDao) jndi.lookup("java:global/EmployeeManagement/EmployeeDaoImpl");
//	}

	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException {
		
		this.dao.insert(newEmployee);
		
		// now call the payroll service
//		try
//		{
//			payrollSystem.enrollEmployee(newEmployee);
//		}
//		catch (SystemUnavailableException e)
//		{
//			// Rollback
//			serverCtx.setRollbackOnly();
//			
//			// Must re-throw the checked exception to the client in an Rollback operation
//			throw e;
//		}
		/**
		 * A much simpler way to do the same as the above (Rollback for checked exceptions),
		 * is to have the exception class (SystemUnavailableException) be annotated with
		 * '@ApplicationException(rollback=true)'. Thats it!
		 */
		payrollSystem.enrollEmployee(newEmployee);
		
		/**
		 * To simulate the Automatic Rollback mechanism in EJBs (happens with unchecked exceptions),
		 * we throw an unchecked exception. 
		 */
//		throw new NullPointerException();
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
	
	public void addEmployeeNote()
	{
		Employee emp = this.dao.findById(201);
		
		emp.addNote("Joined temporarerly today");
		emp.addNote("Leaving on Friday");
	}
}
