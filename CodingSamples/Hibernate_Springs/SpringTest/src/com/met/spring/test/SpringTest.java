package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Address;
import com.met.model.Employee;
import com.met.model.Stage;

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
		
		System.out.println();
		System.out.println("********************Mixing Constructor and Property ***************************");
		
		
		Employee employee7 = appContext.getBean("emp7", Employee.class);
		System.out.println("Employee details with sprinng bean emp7: " + employee7);
		
		System.out.println();
		System.out.println("********************Lazy initialization ***************************");
		
		Employee employee8 = appContext.getBean("emp8", Employee.class);
		System.out.println("Employee details with sprinng bean emp8: " + employee8);
		
		Employee employee8Singleton = appContext.getBean("emp8", Employee.class);
		System.out.println("Employee details with sprinng bean emp8: " + employee8Singleton);
		
		
		
		System.out.println();
		System.out.println("********************Object level singleton ***************************");
		
		Stage stage1 = appContext.getBean("stage1", Stage.class);
		System.out.println("Stage details with stage bean stage1 " + stage1);
		
		Stage stage2 = appContext.getBean("stage2", Stage.class);
		System.out.println("Stage details with stage bean stage2 " + stage2);
		
		if(stage1 == stage2) System.out.println("Stage are identical");
		
		System.out.println();
		System.out.println("********************Address ***************************");
		
		Address address = appContext.getBean("address1", Address.class);
		System.out.println(address);
		
		
		Employee employee9 = appContext.getBean("emp9", Employee.class);
		System.out.println("Employee details with sprinng bean emp9: " + employee9);
		
		
	}
	
}


