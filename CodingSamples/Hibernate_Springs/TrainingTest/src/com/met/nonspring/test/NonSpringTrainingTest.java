package com.met.nonspring.test;

import java.util.ArrayList;
import java.util.List;

import com.met.model.JavaTrainer;
import com.met.model.METSolutions;
import com.met.model.TrainingWorkshop;
import com.met.model.Workshop;

public class NonSpringTrainingTest {

	public static void main(String[] args) {
		
		List<String> subjects = new ArrayList<>(3);
		subjects.add("OOPS");
		subjects.add("JDBC");
		subjects.add("Collections");
		
		JavaTrainer trainer = new JavaTrainer("Ajay", subjects);

		List<String> advSubjects = new ArrayList<>(3);
		advSubjects.add("JSP");
		advSubjects.add("SERVLETS");
		advSubjects.add("RMI");
		
		JavaTrainer advTrainer = new JavaTrainer("VIjay", advSubjects);
		
		METSolutions metSolutions = new METSolutions();
		//metSolutions.setTrainer(trainer);
		metSolutions.setTrainer(advTrainer);
		
		//metSolutions.conductTraining();
		
		
		Workshop tw = new TrainingWorkshop(metSolutions);
		tw.conductWorkshop();
		
		
		
		
		
		
		
	}
	
}
