package com.met.iit.cdac.springbootjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "employeetbl")
public class Employee {

	@Id
	private int id;
	private String name;
	private String emailId;
	private String designation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", emailId=" + emailId + ", designation=" + designation + "]";
	}
	
	
	
}
