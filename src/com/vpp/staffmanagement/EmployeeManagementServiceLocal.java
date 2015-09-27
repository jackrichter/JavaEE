package com.vpp.staffmanagement;

import java.util.List;

import javax.ejb.Local;

import com.vpp.staffmanagement.domain.Employee;

@Local
public interface EmployeeManagementServiceLocal
{
	public void registerEmployee(Employee newEmployee) throws SystemUnavailableException;
	public List<Employee> getAllEmployees();
	public List<Employee> searchBySurname(String surname);
	public void addEmployeeNote();
}
