package com.vpp.backingbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.vpp.staffmanagement.EmployeeManagementServiceLocal;
import com.vpp.staffmanagement.SystemUnavailableException;
import com.vpp.staffmanagement.domain.Employee;

@ManagedBean(name="newEmployee")
public class EnterEmployeePageBean
{
	private String firstName;
	private String surname;
	private String jobRole;
	private int salary;
	
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	
	public EnterEmployeePageBean() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String createEmployee()
	{
		// 1. Business logic - create and store a new Employee
		try 
		{
			Employee emp = new Employee(firstName, surname, jobRole, salary);
			this.employeeService.registerEmployee(emp);
			
			// 2. Redirect to the next page
			return "employeeDetails";
		} 
		catch (SystemUnavailableException e)
		{
			// 2. Redirect to an Error Page
			return "systemDown";
		}
	}
}
