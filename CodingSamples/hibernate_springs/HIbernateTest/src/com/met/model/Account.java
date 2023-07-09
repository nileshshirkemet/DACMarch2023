package com.met.model;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;

@Entity(name = "accounttbl_test")
//@Table(name = "accounttbl")
public class Account {
	
	@Id
	@Column(name = "acc_id")
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50)
	@Size(min = 3, message = "name should be more than 3 characters")
	private String name;
	private double balance;
	
	@Type(type = "yes_no")
	@Column(nullable = true)
	private boolean active;
	
	@Transient
	private double interestRate;
	
	public double calculateInterest() {
		
		interestRate = balance * 0.03;
		return interestRate;
		
	}
	
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
