package com.vpp.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.vpp.staffmanagement.domain.Employee;

@Stateless
public class EmployeeDaoImpl {
	
	/**
	 * Using The "No Interface" from Java 1.6 and onwards. OBS! Used for local interfaces Only. Not remote!
	 */
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Employee newEmployee) 
	{
		em.persist(newEmployee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAll()
	{
		Query q = em.createQuery("select e from Employee e");
		List<Employee> results = q.getResultList();
		
		return results;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findBySurname(String surname)
	{
		List<Employee> results = em.createQuery("select e from Employee e where e.surname = :name")
						.setParameter("name", surname)
						.getResultList();
		
		return results;
	}
}
