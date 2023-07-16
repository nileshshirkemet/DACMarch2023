package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Trainer;
import com.met.model.TrainingCompany;
import com.met.model.Workshop;

public class TrainingTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		
		System.out.println("********************Spring/IOC Container Post initialization");
		
		/*
		 * Trainer trainer1 = context.getBean("javaTrainer1", Trainer.class);
		 * System.out.println(trainer1);
		 */
		//trainer1.train();
		
		
		TrainingCompany trainingCompany = context.getBean("metSolutions", TrainingCompany.class);
		//trainingCompany.conductTraining();
		
		
		Workshop workshop = context.getBean("trainingWorkshop", Workshop.class);
		workshop.conductWorkshop();
		
	}
	
}
