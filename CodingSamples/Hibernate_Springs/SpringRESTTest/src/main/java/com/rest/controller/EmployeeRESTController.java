package com.rest.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.model.Employee;
import com.met.service.EmployeeService;

@RestController
@RequestMapping("/emp")
@CrossOrigin
public class EmployeeRESTController {

	@Autowired
	private EmployeeService employeeService;
	
	//http://localhost:8090/SpringRESTTest/rest/emp/getAllEmps
	
	//@CrossOrigin
	@GetMapping(value = "getAllEmps")
	public Collection<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
		
	}
	
	//http://localhost:8090/SpringRESTTest/rest/emp/getEmp/3
	
	//@CrossOrigin
	@GetMapping(value = "getEmp/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})				//application/json
	public Employee getEmp(@PathVariable int id) {
		
		return employeeService.getEmployee(id);
		
	}
	
	//http://localhost:8090/SpringRESTTest/rest/emp/getXMLEmp/3
	
	/*
	 * @GetMapping(value = "getXMLEmp/{id}", produces =
	 * MediaType.APPLICATION_XML_VALUE) //application/xml public Employee
	 * getXMLEmp(@PathVariable int id) {
	 * 
	 * return employeeService.getEmployee(id);
	 * 
	 * }
	 */
	
	//@CrossOrigin
	@PostMapping(value = "saveEmp", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String saveEmployee(@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		
		return "success";
		
	}
	
	//@PutMapping   -> update
	
	//@DeleteMapping  -> delete
	
}
