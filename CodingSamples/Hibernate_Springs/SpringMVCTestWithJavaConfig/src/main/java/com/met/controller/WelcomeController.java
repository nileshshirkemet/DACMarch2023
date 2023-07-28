package com.met.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/welcome")
public class WelcomeController {

	
	//http://localhost:8090/SpringMVCTest/mvc/welcome
	
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public ModelAndView hello() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		mv.addObject("welMsg", "Welcome to Spring web MVC");
		
		return mv;
		
	}
	
	//http://localhost:8090/SpringMVCTest/mvc/welcome/reqParam
	
	//@RequestMapping(method = RequestMethod.GET, value = "reqParam")
	@GetMapping("reqParam")
	public ModelAndView handleRequest(@RequestParam(required = false, name = "userName") String uname, 
						@RequestParam(defaultValue = "20" ) int age) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("welcome");
		
		mv.addObject("welMsg", "Welcome to Spring web MVC with userName " + uname + " and age " +age );
		
		return mv;
	}
	
	
	@GetMapping("pathVar/{uname}/{age}")
	public ModelAndView pathVar(@PathVariable String uname, @PathVariable int age) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("welcome");
		
		mv.addObject("welMsg", "Welcome to Spring web MVC with userName " + uname + " and age " +age );
		
		return mv;
	}
	
	
}
