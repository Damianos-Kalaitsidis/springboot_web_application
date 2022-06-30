package com.code.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 * This page represents the database of a student 
 * */
@Entity
@Table(name="students")
public class ConnectionWithStudentTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="idStudent")
	private int idStudent;
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	
	public ConnectionWithStudentTable() {
		// TODO Auto-generated constructor stub
	}
	public ConnectionWithStudentTable(int id,int idStudent,String firstName, String lastName,String email) {
		this.id = id;
		this.idStudent = idStudent;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

	}

	public ConnectionWithStudentTable(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	// define tostring

	@Override
	public String toString() {
		return "Student [id=" + id +"idStudent="+idStudent+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
