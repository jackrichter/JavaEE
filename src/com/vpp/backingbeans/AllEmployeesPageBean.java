package com.vpp.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.vpp.staffmanagement.EmployeeManagementServiceLocal;
import com.vpp.staffmanagement.domain.Employee;

@ManagedBean(name="allEmployeesPage")
public class AllEmployeesPageBean
{
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	public String showEmployee()
	{
		return "employeeDetails";
	}
}
