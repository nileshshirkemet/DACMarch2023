package com.met.iit.cdac.springbootjpa.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.springbootjpa.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

//@Component
@Repository

public class EmployeeDAO {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * @Autowired private SessionFactory sessionFactory;
	 */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void saveEmployee(Employee employee) {
		
		entityManager.persist(employee);
	}
	
	public Employee getEmployee(int id) {
		
		return entityManager.find(Employee.class, id);
	}
	
	public Collection<Employee> getAllEmployees(){
		
		
		return entityManager.createQuery("from com.met.iit.cdac.springbootjpa.model.Employee e", Employee.class)
				.getResultList();
		
		
	}
	
}








