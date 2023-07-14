package com.met.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.met.model.Account;

public class HQLTest {
	
	//HQL -> Hibernate Query Language
	
	
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
			
			//select * from accounttbl;
			
			
			Query<Account> createQuery = session.createQuery("from com.met.model.Account a", Account.class);
			List<Account> list = createQuery.list();				// fire the select query
			
			for(Account acc : list) {
				System.out.println(acc);
			}
			
			System.out.println("Restrict number of rows");
			
			
			Query<Account> createQuery2 = session.createQuery("from com.met.model.Account a", Account.class);
			List<Account> list2 = createQuery2.setMaxResults(2).list();		//limit 2				-> MYSQL
																			// rownum <= 2 			-> Oracle
			list2.forEach(x -> System.out.println(x));
			
			
			System.out.println("Ordering records by ID desccending");
			Query<Account> createQuery3 = session.createQuery("from com.met.model.Account a order by a.id desc", Account.class);
			List<Account> list3 = createQuery3.setMaxResults(2).list();		//limit 2				-> MYSQL
																			// rownum <= 2 			-> Oracle
			list3.forEach(x -> System.out.println(x));
			
			
			System.out.println("Fecthing records based on name");
			Query<Account> createQuery4 = session.createQuery("from com.met.model.Account a where a.name=:nameVal", Account.class);
			//List<Account> list4 = createQuery4.setParameter("nameVal", "Jane").list();			
			//list4.forEach(x -> System.out.println(x));
			
			Account singleResult = createQuery4.setParameter("nameVal", "Jane").getSingleResult();
			System.out.println(singleResult);
			
			
			Object uniqueResult = session.createQuery("select sum(balance) from com.met.model.Account a").uniqueResult();
			
			System.out.println(uniqueResult);
			
			
		}
	}

}
