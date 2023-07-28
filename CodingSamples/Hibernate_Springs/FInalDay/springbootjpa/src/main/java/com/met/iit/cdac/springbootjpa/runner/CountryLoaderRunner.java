package com.met.iit.cdac.springbootjpa.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CountryLoaderRunner implements ApplicationRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String[] sourceArgs = args.getSourceArgs();
		
		for(String arg : sourceArgs) {
			System.out.println("Application Runner args " + arg);
		}
		
		System.out.println("Loading Country cache.....");
		
		
	}

}
