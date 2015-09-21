package com.vpp.staffmanagement.test;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.vpp.staffmanagement.domain.Employee;
import com.vpp.staffmanagement.domain.Note;

public class TestHarness {

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDB");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		/**
		 * Tests
		 */
//		TestHarness.testEmployee(em, tx);
//		TestHarness.testNote(em, tx);
//		TestHarness.testEmployeeNoteRelation(em, tx);
//		TestHarness.testQuerryEmployee(em, tx);
		TestHarness.testEmployeeNote_NowUsingCascade(em, tx);
	}
	
	public static void testEmployee(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		// Ch6, adding an object to the database
		Employee employee1 = new Employee("Mark", "Briggs", "Engineer", 10000);
		
		em.persist(employee1);
		
		// Ch7, getting the object from the database
		Employee emp1 = em.find(Employee.class, 1);
		System.out.println(emp1);
		
		// Any change to a persisted object will cause JPA to issue an update upon commit
		emp1.setSurname("Chesterwood");
		emp1.setSurname("King");
		
		// Delete object
		em.remove(emp1);
		
		Employee emp2 = new Employee("Fred", "Jones", "Lamplighter", 10);
		em.persist(emp2);

		tx.commit();
		em.close();
		
		// Employee object still exists in memory (while in method scope), but not in database
		System.out.println(emp1);
	}
	
	public static void testNote(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		Note newNote = new Note("Something happened");
		em.persist(newNote);
		
		tx.commit();
		em.close();
	}
	
	public static void testEmployeeNoteRelation(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
//		Employee newEmp = new Employee("Jack", "Jones", "Programmer", 10000);
//		em.persist(newEmp);
		
		// Find the existing employee and add one more note
		Employee existingEmp = em.find(Employee.class, 251);
		
		Note newNote = new Note("Joined the company today");
		Note secondNote = new Note("Promoted today");
		em.persist(newNote);
		em.persist(secondNote);
		
		existingEmp.addNote(newNote);
		existingEmp.addNote(secondNote);
		
		tx.commit();
		em.close();
	}
	
	public static void testQuerryEmployee(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
		Employee emp = em.find(Employee.class, 151);
		
		Set<Note> notes = emp.getAllNotes();
		
		for (Note next : notes)
		{
			System.out.println(next);
		}
		
		tx.commit();
		em.close();
	}
	
	public static void testEmployeeNote_NowUsingCascade(EntityManager em, EntityTransaction tx)
	{
		tx.begin();
		
//		Employee newEmp = new Employee("Jack", "Jones", "Programmer", 10000);
//		em.persist(newEmp);
		
		// Find the existing employee and add one more note
		Employee existingEmp = em.find(Employee.class, 401);
		
		existingEmp.addNote("Joined temporarerly today");
		existingEmp.addNote("Leaving on Friday");
		
		tx.commit();
		em.close();
	}
		
}
