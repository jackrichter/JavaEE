package com.vpp.staffmanagement.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vpp.staffmanagement.domain.Employee;

public class TestJPQL {

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDB");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		TestJPQL.createEmployees(em, tx);
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
