package com.nt.entity;

public abstract class Egg {
	double proteins;

	double fats;
	double carbs;
	double tastyScore;
	
	public Egg() {
		// TODO Auto-generated constructor stub
	}
	

	public Egg(double proteins, double fats, double carbs, double tastyScore) {
		
		this.proteins = proteins;
		this.fats = fats;
		this.carbs = carbs;
		this.tastyScore = tastyScore;
	}
	public abstract void getNutritutions();
	public void getType()
	{
		System.out.println("super method");
	}
}
