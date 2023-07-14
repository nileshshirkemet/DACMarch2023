package com.met.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int id;
	@Column(length = 15)
	private String city;
	@Column(length = 15)
	private String country;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Address(String city, String country) {
		super();
		this.city = city;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
}
