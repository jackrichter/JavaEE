package com.vpp.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import com.vpp.staffmanagement.EmployeeManagementServiceLocal;
import com.vpp.staffmanagement.domain.Employee;

@ManagedBean(name="allEmployeesPage")
public class AllEmployeesPageBean
{
	@EJB
	private EmployeeManagementServiceLocal employeeService;
	
	private UIData dataTable;
	private Employee selectedEmployee;
	
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	public String showEmployee()
	{
		// Get hold of a reference to the sought employee object via the dataTable object stored in the server
		this.selectedEmployee = (Employee) this.dataTable.getRowData();
		
		// Redirect to the rendering page
		return "employeeDetails";
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public Employee getSelectedEmployee() {
		return selectedEmployee;
	}

	public void setSelectedEmployee(Employee selectedEmployee) {
		this.selectedEmployee = selectedEmployee;
	}
}
