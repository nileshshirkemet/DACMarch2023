package com.met.model;

public class Employee {
	
	private static int count;
	
	private int id;
	
	private String name;
	private int age;
	private double salary;
	private String designation;
	private Address address;
	
	public Employee() {
		super();
		id = ++count;
		System.out.println("Default employee created with id: " + id);
		// TODO Auto-generated constructor stub
	}
	
	
	public Employee(String name, int age) {
		this();
		this.name = name;
		this.age = age;
		this.designation = "FRESHER";
		this.salary = 60000;
		
		System.out.println("EMployee object created from param const with id: " + id);
	}
	
	public Employee(String name, int age, double salary, String designation, Address address) {
		this();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.address = address;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", designation="
				+ designation + ", address=" + address + "]";
	}
	
	
}
