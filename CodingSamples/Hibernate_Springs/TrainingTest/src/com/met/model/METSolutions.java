package com.met.model;

import javax.sql.DataSource;

public class METSolutions implements TrainingCompany{

	private Trainer trainer;
	
	//private DataSource dataSource;
	
	public METSolutions() {
		super();
		System.out.println("Default constructor of METSolutions invoked");
	}

	public METSolutions(Trainer trainer) {
		super();
		this.trainer = trainer;
		System.out.println("Parameterized constructor of METSolutions invoked");
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public void conductTraining() {
		// TODO Auto-generated method stub
		
		System.out.println("METSolutions :: conductTraining");
		trainer.train();
		
		//dataSource.getClass();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a TrainingCompany";
	}
}


