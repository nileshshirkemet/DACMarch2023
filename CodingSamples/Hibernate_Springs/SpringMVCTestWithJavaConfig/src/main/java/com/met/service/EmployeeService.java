package com.met.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.met.dao.EmployeeDAO;
import com.met.model.Employee;

//@Component
@Service
public class EmployeeService {

	//private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void saveEmployee(Employee employee) {
				
		//validation
		
		if(employee.getId() < 0) {
			throw new RuntimeException("ID cannot be < 0");
		}
		
		System.out.println("EmployeeDAO get class" + employeeDAO.getClass());
		employeeDAO.saveEmployee(employee);
		
	}
	
	public Collection<Employee> getAllEmployees(){
		
		return employeeDAO.getAllEmployees();
	}
	
	public Employee getEmployee(int id) {
		
		return employeeDAO.getEmployee(id);
	}
}




