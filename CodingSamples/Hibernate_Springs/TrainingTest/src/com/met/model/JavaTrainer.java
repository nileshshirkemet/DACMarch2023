package com.met.model;

import java.util.List;

public class JavaTrainer implements Trainer{

	private String name;
	private List<String> subjects;
	
	public JavaTrainer() {
		super();
		System.out.println("Default constructor of JavaTrainer invoked");
	}

	public JavaTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		System.out.println("Parameterized constructor of JavaTrainer invoked");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public void train() {
		System.out.println("JavaTrainer  :: train()");
		
		System.out.println(name + " is training on javaSubjects " + subjects);
		
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a JavaTrainer";
	}
}
