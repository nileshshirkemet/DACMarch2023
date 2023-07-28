package com.met.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.model.Employee;
import com.met.service.EmployeeService;

//@Component
@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	//private EmployeeService employeeService = new EmployeeService();
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ModelAndView initializeForm() {
		
		ModelAndView mv = new ModelAndView();
		
		Employee employeeDef = new Employee();
		
		mv.addObject("employee", employeeDef);
		
		Collection<Employee> allEmployees = employeeService.getAllEmployees();
		
		mv.addObject("empList", allEmployees);
		
		
		mv.setViewName("emp");
		
		return mv;
		
	}
	
	

	
	@PostMapping
	public ModelAndView saveEmp(@ModelAttribute Employee employee) {
		
		System.out.println(employee);
		
		ModelAndView mv = new ModelAndView();
		
		employeeService.saveEmployee(employee);
		
Collection<Employee> allEmployees = employeeService.getAllEmployees();
		
		mv.addObject("empList", allEmployees);
		
		mv.setViewName("emp");
		
		
		
		return mv;
		
	}
	
	@ExceptionHandler
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("exMsg", ex.getMessage());
		
		mv.addObject("url", request.getRequestURI());
		
		mv.setViewName("error");
		
		return mv;
		
		
	}
	
}



