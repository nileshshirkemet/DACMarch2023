package com.met.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*<bean id="metSolutions" class="com.met.model.METSolutions" autowire="byType">*/

@Component("metSolutions")
public class METSolutions implements TrainingCompany{

	/*
	 * @Autowired private Trainer trainer;
	 * 
	 * //private DataSource dataSource;
	 * 
	 * public METSolutions() { super();
	 * System.out.println("Default constructor of METSolutions invoked"); }
	 * 
	 * public METSolutions(Trainer trainer) { super(); this.trainer = trainer;
	 * System.out.println("Parameterized constructor of METSolutions invoked"); }
	 * 
	 * public Trainer getTrainer() { return trainer; }
	 * 
	 * public void setTrainer(Trainer trainer) { this.trainer = trainer; }
	 * 
	 * @Override public void conductTraining() { // TODO Auto-generated method stub
	 * 
	 * System.out.println("METSolutions :: conductTraining"); trainer.train();
	 * 
	 * //dataSource.getClass();
	 * 
	 * }
	 * 
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return "METSolutions is a TrainingCompany"; }
	 */
	
	@Autowired
	private List<Trainer> trainers;
	
	@Autowired(required = false)
	private DataSource dataSource;
	
	//private DataSource dataSource;
	
	public METSolutions() {
		super();
		System.out.println("Default constructor of METSolutions invoked");
	}

	public METSolutions(List<Trainer> trainers) {
		super();
		this.trainers = trainers;
		System.out.println("Parameterized constructor of METSolutions invoked");
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	@Override
	public void conductTraining() {
		// TODO Auto-generated method stub
		
		System.out.println("METSolutions :: conductTraining");
		//trainers.train();
		
		for(Trainer trainer : trainers) {
			trainer.train();
		}
		
		//dataSource.getClass();
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a TrainingCompany";
	}
	
}


