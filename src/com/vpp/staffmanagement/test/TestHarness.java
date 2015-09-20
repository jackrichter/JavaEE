package com.vpp.staffmanagement.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vpp.staffmanagement.domain.Employee;

public class TestHarness {

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDB");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Employee employee1 = new Employee("Mark", "Briggs", "Engineer", 10000);
		
		em.persist(employee1);

		tx.commit();
		em.close();
	}
}
