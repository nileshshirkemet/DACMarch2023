package com.met.model;

public class Address {

	private static int counter;
	
	private String id;
	private String city;
	private String country;
	
	public Address() {
		super();
		id = "A" + ++counter;
		System.out.println("Default Address object created with id: " + id);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
}
