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
		
		
		
		
		try(Session session = sessionFactory.openSession()){		//connection to db
			
			tx = session.beginTransaction();					//starting tx
			
			Serializable serializable = session.save(acc);
			System.out.println("ID of account: " + serializable);
			
			//session.persist(acc);
			
			tx.commit();
			
		}catch (HibernateException e) {
			System.out.println(e);
			e.printStackTrace();
			
			if(tx != null) tx.rollback();
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
		
		
		
	}
	
	public static void main(String[] args) {
		
		Account account = new Account();
		//account.setId(6);						//assigned primary key value
		account.setName("Rahul");
		account.setBalance(89000);
		//account.setActive(true);
		
		CRUDTest test = new CRUDTest();
		//test.saveAccount(account);
		
		test.getLoadTest();
		
		sessionFactory.close();
		
	}
	
	
}


