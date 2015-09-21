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
		
		// Ch6, adding an object to the database
//		Employee employee1 = new Employee("Mark", "Briggs", "Engineer", 10000);
		
//		em.persist(employee1);
		
//		// Ch7, getting the object from the database
//		Employee emp1 = em.find(Employee.class, 1);
//		System.out.println(emp1);
//		
//		// Any change to a persisted object will cause JPA to issue an update upon commit
//		emp1.setSurname("Chesterwood");
//		emp1.setSurname("King");
//		
//		// Delete object
//		em.remove(emp1);
		
		Employee emp2 = new Employee("Fred", "Jones", "Lamplighter", 10);
		em.persist(emp2);

		tx.commit();
		em.close();
		
		// Employee object still exists in memory (while in method scope), but not in database
//		System.out.println(emp1);
	}
}
