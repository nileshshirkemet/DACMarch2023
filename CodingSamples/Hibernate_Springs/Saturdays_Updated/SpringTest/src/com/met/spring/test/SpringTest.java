package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Employee;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("test.xml");
		
		
		System.out.println("***********************Post Spring container initialization******************");
		
		/*
		 * Employee employee = appContext.getBean(Employee.class);
		 * System.out.println(employee);
		 */
		
		Employee empObj = (Employee) appContext.getBean("emp1");
		System.out.println(empObj);
		
		Employee emp = appContext.getBean("emp1", Employee.class);
		System.out.println(emp);
		
		
		Employee employee2 = appContext.getBean("emp2", Employee.class);
		System.out.println("Employee details with sprinng bean emp2: " + employee2);
		
		
		System.out.println();
		System.out.println("********************Prototype beans***************************");
		
		
		Employee employee3 = appContext.getBean("emp3", Employee.class);
		System.out.println("Employee details with sprinng bean emp3: " + employee3);
		
		Employee employee3Proto = appContext.getBean("emp3", Employee.class);
		System.out.println("Employee details with sprinng bean emp3: " + employee3Proto);
		
		System.out.println();
		System.out.println("********************Parameterized const***************************");
		
		Employee employee4 = appContext.getBean("emp4", Employee.class);
		System.out.println("Employee details with sprinng bean emp4: " + employee4);
		
		Employee employee5 = appContext.getBean("emp5", Employee.class);
		System.out.println("Employee details with sprinng bean emp5: " + employee5);
		
		System.out.println();
		System.out.println("********************Property ***************************");
		
		Employee employee6 = appContext.getBean("emp6", Employee.class);
		System.out.println("Employee details with sprinng bean emp6: " + employee6);
		
	}
	
}
