package com.vpp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.vpp.staffmanagement.domain.Employee;

@Stateless
public class EmployeeDaoImpl {
	
	/**
	 * Using The "No Interface" from Java 1.6 and onwards. OBS! Used for local interfaces Only. Not remote!
	 */

	public void insert(Employee newEmployee) {
		// TODO Auto-generated method stub

	}

	public List<Employee> findAll() {
		
		List<Employee> tempList = new ArrayList<Employee>();
		tempList.add(new Employee("Richard", "Chesterwood", "Presenter", 10));
		tempList.add(new Employee("Mathew", "Adams", "Producer", 1000));
		
		return tempList;
	}

	public List<Employee> findBySurname(String surname) {
		
		List<Employee> tempList = new ArrayList<Employee>();
		tempList.add(new Employee("Temp", "Temp", "Temp", 1000));
		
		return tempList;
	}
}
