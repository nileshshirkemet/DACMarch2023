package com.met.iit.cdac.springbootweb.dao;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.springbootweb.model.Employee;

//@Component
@Repository

public class EmployeeDAO {
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public void saveEmployee(Employee employee) {
		
		System.out.println("EmployeeDAO  :: saveEmployee into db" + employee);
		
		jdbcTemplate.update("insert into employeetbl values (?, ?, ?, ?)", 
				
				new Object[] {						
						employee.getId(), employee.getName(), employee.getEmailId(), employee.getDesignation()
				}
				
				);
	}
	
	public Employee getEmployee(int id) {
		
		return jdbcTemplate.queryForObject("select * from employeetbl where id=?", new BeanPropertyRowMapper<Employee>(Employee.class),
				id);
		
	}
	
	public Collection<Employee> getAllEmployees(){
		
		
		return jdbcTemplate.query("select * from employeetbl", 
				new BeanPropertyRowMapper<Employee>(Employee.class)
				
				);
		
		
	}
	
}








