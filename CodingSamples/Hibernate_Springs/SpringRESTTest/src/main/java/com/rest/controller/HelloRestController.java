package com.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("hello")
public class HelloRestController {

	
	//http://localhost:8090/SpringRESTTest/rest/hello
	
	/*
	 * @GetMapping public @ResponseBody String welcome() { return
	 * "Welcome to REST Web Services"; }
	 */
	
	
	/*
	 * @GetMapping public @ResponseBody ResponseEntity<String> welcomeEntity(){
	 * 
	 * return new ResponseEntity<String>("Welcome to REST Web Services",
	 * HttpStatus.OK);
	 * 
	 * }
	 */
	
	//@RestController -> @Controller + @ResponseBody
	
	
	@GetMapping
	public ResponseEntity<String> welcomeEntity(){
		
		return new ResponseEntity<String>("Welcome to REST Web Services", HttpStatus.OK);
		
	}
	
	@GetMapping("withHeaders")
	public ResponseEntity<String> welcomeWithHeaders(){
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("count", "5");
		
		return new ResponseEntity<String>("Welcome to REST Web Services", httpHeaders, 
				HttpStatus.OK);
		
	}
	
	
	
	
	
}
