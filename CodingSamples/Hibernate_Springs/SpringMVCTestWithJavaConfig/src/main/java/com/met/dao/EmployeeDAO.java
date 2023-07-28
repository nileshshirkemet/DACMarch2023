package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.model.Employee;

//@Component
@Repository

public class EmployeeDAO {
	
	@Autowired
	@Qualifier("oracleDataSource")
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//noRollbackFor = NullPointerException.class
	@Transactional(rollbackFor = Exception.class, timeout = 20, 
			transactionManager = "hibernateTransactionManager", propagation = Propagation.REQUIRED)
	public void saveEmployee(Employee employee) {
		
		System.out.println("EmployeeDAO  :: saveEmployee into db" + employee);
		//saveEmployeeUsingDataSource(employee);
		
		
		//saveUsingJDBCTemplate(employee);
		
		//saveUsingHibernate(employee);
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(employee);
		
	}
	
	@Transactional(readOnly = true)
	public Employee getEmployee(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		return (Employee) session.get(Employee.class, id);
		
		
	}
	
	public void saveEmployeeUsingDataSource(Employee employee) {
		
		try(Connection connection = dataSource.getConnection();
				PreparedStatement pstmt = connection.prepareStatement("insert into employeetbl values (?, ?, ?, ?)")
			){
			
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getEmailId());
			pstmt.setString(4, employee.getDesignation());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public void saveUsingJDBCTemplate(Employee employee) {
		
		jdbcTemplate.update("insert into employeetbl values (?, ?, ?, ?)", 
				
				new Object[] {						
						employee.getId(), employee.getName(), employee.getEmailId(), employee.getDesignation()
				}
				
				);
		
		
	}
	
	public Collection<Employee> getAllEmployees(){
		
		
		return jdbcTemplate.query("select * from employeetbl", 
				new BeanPropertyRowMapper<Employee>(Employee.class)
				
				);
		
		
	}
	
	public void saveUsingHibernate(Employee employee) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			session.save(employee);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			if(session != null) session.close();
		}
		
	}
	
}








