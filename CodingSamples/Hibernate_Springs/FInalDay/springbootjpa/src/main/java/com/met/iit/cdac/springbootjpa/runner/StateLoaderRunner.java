package com.met.iit.cdac.springbootjpa.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class StateLoaderRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		for(String ar : args) {
			System.out.println("Command line arguemnets  " + ar);
		}
		
		System.out.println("Loading state cache based on countries");
		
		
	}

	
	
}
