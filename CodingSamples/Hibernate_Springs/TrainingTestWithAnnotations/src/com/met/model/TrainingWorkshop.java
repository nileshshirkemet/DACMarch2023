package com.met.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//<bean id="tw" class="com.met.model.TrainingWorkshop" autowire="constructor">

//<bean id="tw" class="com.met.model.TrainingWorkshop" -> @Component
//autowire -> @Autowired	

@Component
public class TrainingWorkshop implements Workshop{

	private TrainingCompany trainingCompany;
	
	@Autowired
	public TrainingWorkshop(TrainingCompany trainingCompany) {
		super();
		this.trainingCompany = trainingCompany;
		System.out.println("Parameterized constructor of TrainingWorkshop invoked");
	}

	public TrainingWorkshop() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor of TrainingWorkshop invoked");
	}

	public TrainingCompany getTrainingCompany() {
		return trainingCompany;
	}

	public void setTrainingCompany(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	@Override
	public void conductWorkshop() {
		
		System.out.println("TrainingWorkshop :: conductWorkshop");
		trainingCompany.conductTraining();
	}
	
}
