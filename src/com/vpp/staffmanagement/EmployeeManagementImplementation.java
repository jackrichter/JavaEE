package com.vpp.staffmanagement;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.vpp.staffmanagement.domain.Employee;

@Stateless
public class EmployeeManagementImplementation implements EmployeeManagementService {

	@Override
	public void registerEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> tempList = new ArrayList<Employee>();
		tempList.add(new Employee("Richard", "Chesterwood", "Presenter", 10));
		tempList.add(new Employee("Mathew", "Adams", "Producer", 1000));
		
		return tempList;
	}

	@Override
	public List<Employee> searchBySurname(String surname) {
		
		List<Employee> tempList = new ArrayList<Employee>();
		tempList.add(new Employee("Temp", "Temp", "Temp", 1000));
		
		return tempList;
	}

}
