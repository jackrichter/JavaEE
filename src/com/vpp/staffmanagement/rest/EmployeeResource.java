package com.vpp.staffmanagement.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.vpp.staffmanagement.EmployeeManagementServiceLocal;
import com.vpp.staffmanagement.domain.Employee;

@Path("/employees")
@Stateless			// OBS! Needs to add this in order to get the dependency injection to an EJB to work!
public class EmployeeResource
{
	@EJB
	private EmployeeManagementServiceLocal serviveEjb;
	
	@GET
	@Produces("application/xml")
	public List<Employee> getAllEmplyees() 
	{
		return this.serviveEjb.getAllEmployees();
	}
	
	@GET
	@Produces("application/xml")
	@Path("{id}")		// matches the URL of /employees/{id} (any sting like 221 or 345 etc.) 
	public Employee findEmployeeById(@PathParam("id") String id)
	{
		return this.serviveEjb.getEmployeeById(Integer.parseInt(id));
	}
}
