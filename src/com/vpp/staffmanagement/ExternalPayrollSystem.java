package com.vpp.staffmanagement;

import javax.ejb.Stateless;

import com.vpp.staffmanagement.domain.Employee;

@Stateless
public class ExternalPayrollSystem 
{

	/**
	 * Simulates an unreliable process that might throw a checked exception
	 * half of time.
	 * This is to simulate programmatic Rollback.
	 * @throws SystemUnavailableException 
	 */
	public void enrollEmployee(Employee newEmployee) throws SystemUnavailableException
	{
//		if(Math.random() < 0.5)
		if(Math.random() < 0.1)
		{
			throw new SystemUnavailableException();
		}
		else
		{
			// do some complex processing
		}
	}
}
