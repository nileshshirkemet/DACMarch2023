package com.met.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class CRUDTest {

	static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	
	public void saveAccount(Account acc) {
		Transaction tx = null;
		
		//acc -> Transient state
		
		
		try(Session session = sessionFactory.openSession()){		//connection to db
			
			tx = session.beginTransaction();					//starting tx
			
			Serializable serializable = session.save(acc);
			System.out.println("ID of account: " + serializable);
			
			//acc is in persistent state
			
			//session.persist(acc);
			
			tx.commit();
			
		}catch (HibernateException e) {
			System.out.println(e);
			e.printStackTrace();
			
			if(tx != null) tx.rollback();
		}
		
		//acc   -> Dettached state 
		
		
	}
	
	
	public void updateAccount(int id) {	//peristent state
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account = session.get(Account.class, id);
			
			System.out.println("Before update value of accnt: " + account);
			
			
			account.setActive(false);

			//session.update(account);
			
			tx.commit();
			
		}
		
		
	}
	
	public void updateDettachedAccount(int id) {
		
		Transaction tx = null;
		Account account = null;
		
		try(Session session = sessionFactory.openSession()){
			
				
			account = session.get(Account.class, id);		//4
			//account -> persistent state
			
			
		}
		
		//goes away for 30 mins
		
		//account   -> dettached
		
		//user comes back
		
		account.setBalance(190000);
		
		try(Session session = sessionFactory.openSession()){
			tx = session.beginTransaction();
			
			//Account account1 = session.get(Account.class, id);	
			
			session.update(account);
			
			tx.commit();
		}
	}
	
	public void updateWithTransient() {
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = new Account();
			account.setName("Sam");
			account.setBalance(91000);
			
			tx = session.beginTransaction();
			
			session.update(account);
			
			tx.commit();
			
		}
		
		//saveOrUpdate()
		
	}
	
	public void getAccount(int id) {
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
			System.out.println("account :: Account Id name: " + account.getName());
			System.out.println("account :: Interest is " + account.calculateInterest());
			
			Account account1 = session.get(Account.class, id);
			System.out.println("account1 :: Account Id name: " + account1.getName());
			System.out.println("account1 :: Interest is " + account1.calculateInterest());
			
			if(account == account1) {
				System.out.println("Accounts are identical");
			}
			
		}
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
			System.out.println("account :: Account Id name: " + account.getName());
			System.out.println("account :: Interest is " + account.calculateInterest());
			
		}
		
	}
	
	public void deleteAccount(int id) {
		

		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account = session.get(Account.class, id);
			
			session.delete(account);
			
			tx.commit();
			
		}
		
	}
	
	
	public void evictTest() {
		
		try(Session session = sessionFactory.openSession()){
			
			Account account1 = session.get(Account.class, 1);
			Account account2 = session.get(Account.class, 2);
			Account account3 = session.get(Account.class, 3);
			Account account4 = session.get(Account.class, 4);
			
			
System.out.println("account1 present in session " + session.contains(account1));
System.out.println("account2 present in session " + session.contains(account2));
System.out.println("account3 present in session " + session.contains(account3));
System.out.println("account4 present in session " + session.contains(account4));
			
			session.evict(account2);

			System.out.println();
			System.out.println("**************calling evict on account2***************");
			
			System.out.println("account1 present in session " + session.contains(account1));
			System.out.println("account2 present in session " + session.contains(account2));
			System.out.println("account3 present in session " + session.contains(account3));
			System.out.println("account4 present in session " + session.contains(account4));
									
			session.clear();
				
			

			System.out.println();
			System.out.println("**************calling clear***************");
			
			System.out.println("account1 present in session " + session.contains(account1));
			System.out.println("account2 present in session " + session.contains(account2));
			System.out.println("account3 present in session " + session.contains(account3));
			System.out.println("account4 present in session " + session.contains(account4));
			
			
			
		}
		
	}
	

	public void getLoadTest() {
		
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, 1);				//Eager initialization
			System.out.println("HIbernate GET method");
			System.out.println(account.getClass());
			System.out.println(account.getId());
			
			Account account1 = session.load(Account.class, 150);				//lazy initialization
			System.out.println("HIbernate load method");
			System.out.println(account1.getClass());
			System.out.println(account1.getId());
			
			
			System.out.println("Account balance: " + account1.getBalance());
			
		}
		
	public static void main(String[] args) {
		
		Account account = new Account();
		//account.setId(6);						//assigned primary key value
		account.setName("Rahul");
		account.setBalance(89000);
		//account.setActive(true);
		
		CRUDTest test = new CRUDTest();
		//test.saveAccount(account);
		
		//test.getAccount(3);
		
		//test.updateAccount(6);
		
		//test.updateWithTransient();
		
		//test.updateDettachedAccount(4);
		
		//test.deleteAccount(10);
		
		test.evictTest();
		
		sessionFactory.close();
		
	}
	
	
}


