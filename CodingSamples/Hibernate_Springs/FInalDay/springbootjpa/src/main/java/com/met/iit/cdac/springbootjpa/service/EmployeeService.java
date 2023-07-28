package com.met.iit.cdac.springbootjpa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.met.iit.cdac.springbootjpa.dao.EmployeeDAO;
import com.met.iit.cdac.springbootjpa.dao.EmployeeRepository;
import com.met.iit.cdac.springbootjpa.model.Employee;

//@Component
@Service
public class EmployeeService {

	//private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	/*
	 * @Autowired private EmployeeDAO employeeDAO;
	 */
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public void saveEmployee(Employee employee) {
				
		//validation
		
		if(employee.getId() < 0) {
			throw new RuntimeException("ID cannot be < 0");
		}
		
		/*
		 * System.out.println("EmployeeDAO get class" + employeeDAO.getClass());
		 * employeeDAO.saveEmployee(employee);
		 */
		

		employeeRepository.save(employee);
		
	}
	
	public Collection<Employee> getAllEmployees(){
		
		/* return employeeDAO.getAllEmployees(); */
		System.out.println("employeeRepository get class" + employeeRepository.getClass());
		return employeeRepository.findAll();
	}
	
	public Employee getEmployee(int id) {
		
		/* return employeeDAO.getEmployee(id); */
		
		return employeeRepository.findById(id).get();
	}
}




