package com.met.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Address;
import com.met.model.Employee;

public class Test {
	
	
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		
		Employee employee = new Employee();
		employee.setName("Jack");
		employee.setEmailId("jack@met.edu");
		
		Address address = new Address("Mumbai", "India");
		Address address1 = new Address("Pune", "India");
		
		List<Address> listAddresses = new ArrayList<>(2);
		listAddresses.add(address);
		listAddresses.add(address1);
		
		employee.setAddressList(listAddresses);
		
		
		try(Session session = sessionFactory.openSession()){
			
			Transaction tx = session.beginTransaction();
			
			session.save(employee);
			
			tx.commit();
			
		}
		
	}
	
}