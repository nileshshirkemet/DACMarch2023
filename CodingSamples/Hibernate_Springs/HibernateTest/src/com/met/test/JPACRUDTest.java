package com.met.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;


public class JPACRUDTest {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void saveUsingJPA(Account acc) {
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			session.persist(acc);
			
			tx.commit();
			
		}
		
	}
	
	public void jpaMergeForPersistent(int id) {
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			
			Account account = session.get(Account.class, id);
			
			account.setActive(true);
			account.setBalance(90000);
			
			session.merge(account);
			
			tx.commit();
			
		}
		
	}

	public void jpaMergeForDettached(int id) {
		
		Account acc = null;
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			System.out.println("Session 1");
			acc = session.get(Account.class, id);
			//acc -> persistent state
			
		}
		
		//acc is in dettached state
		
		//after 30 mins user comes and updates balance = 88000
		acc.setBalance(70000);
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			System.out.println();
			System.out.println("Session 2");
			Account acc1 = session.get(Account.class, 3);			//select query 
			
			System.out.println("MERGE ::         ");
			
			session.merge(acc);										//
			
			
			tx.commit();
		}
		
		
		
		
	}
	
	public void jpaMergeForTransient() {
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			Account acc = new Account();
			acc.setActive(true);
			acc.setName("Jane");
			acc.setBalance(98250);
			
			//acc ->  transient state
			
			tx = session.beginTransaction();
			
			session.merge(acc);
			
			tx.commit();
			
		}
		
	}
	
	
	public void jpaRemoveObject(int id) {
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			
			Account account = session.get(Account.class, id);
			
			session.remove(account);
			
			tx.commit();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Account acc = new Account();
		//acc.setId(5);
		acc.setBalance(80000);
		acc.setName("Sameer");
		
		JPACRUDTest test = new JPACRUDTest();
		//test.saveUsingJPA(acc);
		
		//test.jpaMergeForPersistent(2);
		
		//test.jpaMergeForDettached(3);
		
		//test.jpaMergeForTransient();
		
		test.jpaRemoveObject(3);
	}
	
	
}
