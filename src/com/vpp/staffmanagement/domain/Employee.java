package com.vpp.staffmanagement.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
//@Table(name="TBL_EMPL")
public class Employee implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//	@Column(name="VC_FIRST")
	private String firstName;
	private String surname;
	private String jobRole;
	private int salary;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="fk_employee_id")
	private Set<Note> notes;
	
	/**
	 * Required by JPA
	 */
	public Employee() {}

	public Employee(String firstName, String surname, String jobRole, int salary) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.jobRole = jobRole;
		this.salary = salary;
		this.notes = new HashSet<Note>();
	}
	
	@Override
	public String toString() {
		return "Employee " + this.firstName + " " + this.surname;
	}

	public void setSurname(String newSurname) {
		this.surname = newSurname;
	}
	
	public void addNote(Note newNote)
	{
		this.notes.add(newNote);
	}
	
	public void addNote(String newNoteText)
	{
		Note newNote = new Note(newNoteText);
		this.notes.add(newNote);
	}

	public Set<Note> getAllNotes() 
	{
		return this.notes;
	}
}
