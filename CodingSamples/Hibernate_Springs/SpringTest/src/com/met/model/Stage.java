package com.met.model;

public class Stage {

	private static int count;
	
	private int id;
	
	private Stage() {
		
		id = ++count;
		
		System.out.println("Stage object created with id " + id);
	}
	
	private static Stage stage = new Stage();
	
	public static Stage getStage() {
		return stage;
	}

	@Override
	public String toString() {
		return "Stage [id=" + id + "]";
	}
	
	
	
}
