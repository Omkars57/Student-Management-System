package com.example.sms.entity;

import org.hibernate.annotations.Tables;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Students") 	//as a JPA entity using JPA annotation
public class Student {
	
	@Id		//to make primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false) //-->to give column name in table which JPA trace internally with this annotations
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
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
	
	public Student() { //default constructor hibernate internally uses proxy to create objects dynamically
		
	}
	/**
	 * @param iD
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public Student(long iD, String firstName, String lastName, String email) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	

}
