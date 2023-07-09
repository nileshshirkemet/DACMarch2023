package com.met.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class AccountTest {

	static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	
	public void saveAccount(Account acc) {
		Transaction tx = null;
		
		
		
		
		try(Session session = sessionFactory.openSession()){		//connection to db
			
			tx = session.beginTransaction();					//starting tx
			
			session.persist(acc);						
			
			tx.commit();
			
		}catch (HibernateException e) {
			System.out.println(e);
			e.printStackTrace();
			
			if(tx != null) tx.rollback();
		}
	}
	
	
	public static void main(String[] args) {
		
		Account account = new Account();
		account.setId(1);
		account.setName("Jack");
		account.setBalance(80000);
		account.setActive(true);
		
		AccountTest test = new AccountTest();
		test.saveAccount(account);
		
		sessionFactory.close();
		
	}
	
	
}


