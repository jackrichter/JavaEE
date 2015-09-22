package com.vpp.staffmanagement.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.vpp.staffmanagement.domain.Employee;

public class TestJPQL {

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDB");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
//		TestJPQL.createEmployees(em, tx);
//		TestJPQL.queryEmployeeTbl(em, tx);
//		TestJPQL.preparedQueryEmployeeTbl(em, tx);
//		TestJPQL.testNamedQuery(em, tx);
//		TestJPQL.testReportdQuery(em, tx);
		TestJPQL.testAggregationdQuery(em, tx);
	}
	
	public static void testAggregationdQuery(EntityManager em, EntityTransaction tx)
	{
		/**
		 * A form of report query but much more efficient in terms of performance and memory use.
		 * Also available: min, max, sum and avg. 
		 */
		
		tx.begin();
		
		// First requirement is the total numbers of employees
		Query q = em.createQuery("select count(e) from Employee e");
		long empNum = (long) q.getSingleResult();
		
		System.out.println("We have " + empNum + " employees");
		
		// Second requirement is the average salary of all employees
		Query q2 = em.createQuery("select avg(e.salary) from Employee e");
		double avgSalary = (double) q2.getSingleResult();
		
		System.out.println("The average salary is " + avgSalary);
		
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void testReportdQuery(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		/**
		 * This type of query will not return an object like Employee,
		 * but rather an Object[], which in this case contains two Strings
		 */
		Query q = em.createQuery("select e.firstName, e.surname from Employee e");
		
		// Execute
		List<Object []> results = q.getResultList();
		
		for (Object[] next : results) 
		{
			System.out.println("First Name " + next[0]);
			System.out.println("Surname " + next[1]);
		}
		
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void testNamedQuery(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		String requiredName = "Richard";
		
		/**
		 * Queries stored in properties file: orm.xml
		 */
		
		List<Employee> results = em.createNamedQuery("searchByFirstname")
				.setParameter("name", requiredName)
				.getResultList();
		
		for (Employee next : results)
		{
			System.out.println(next);
		}
		
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void testFluentAPIStyle(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		String requiredName = "Richard";
		
		List<Employee> results = em.createQuery("select e from Employee e where e.firstName = :name")
				.setParameter("name", requiredName)
				.getResultList();
		
		for (Employee next : results)
		{
			System.out.println(next);
		}
		
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void preparedQueryEmployeeTbl(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		String requiredName = "Richard";
		
		Query q = em.createQuery("select e from Employee e where e.firstName = :name");
		q.setParameter("name", requiredName);
		List<Employee> results = q.getResultList();
		
		for (Employee next : results)
		{
			System.out.println(next);
		}
		
		tx.commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void queryEmployeeTbl(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
//		Query q = em.createQuery("select e from Employee e where e.jobRole = 'Jockey'");
		Query q = em.createQuery("select e from Employee e where e.firstName  like 'R%'");
		List<Employee> results = q.getResultList();
		
		for (Employee next : results)
		{
			System.out.println(next);
		}
		
		tx.commit();
		em.close();
	}
	
	public static void createEmployees(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		Employee emp2 = new Employee("Marcus", "Armytage", "Journalist", 45000);
		Employee emp3 = new Employee("Nigel", "Hawke", "Jockey", 13500);
		Employee emp4 = new Employee("Carl", "Llwellyn", "Landlord", 127000);
		Employee emp5 = new Employee("Richard", "Dunwoody", "Explorer", 98000);
		Employee emp6 = new Employee("Jason", "Titley", "Jockey", 70000);
		Employee emp7 = new Employee("Mick", "Fitzgerald", "TV Presenter", 78000);
		Employee emp8 = new Employee("Tony", "Dobbin", "Jockey", 8000);
		Employee emp9 = new Employee("Paul", "Carberry", "Jockey", 72000);
		Employee emp10 = new Employee("Rupert", "Walsh", "TV Presenter", 182000);
		Employee emp11 = new Employee("Richard", "Guest", "Trainer", 9000);
		
		em.persist(emp2);
		em.persist(emp3);
		em.persist(emp4);
		em.persist(emp5);
		em.persist(emp6);
		em.persist(emp7);
		em.persist(emp8);
		em.persist(emp9);
		em.persist(emp10);
		em.persist(emp11);
		
		tx.commit();
		em.close();
	}
}
