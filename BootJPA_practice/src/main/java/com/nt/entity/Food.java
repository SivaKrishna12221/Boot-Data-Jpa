package com.nt.entity;

public class Food extends Egg
{
	int tastyScore=7;
    String type="non-vegitarian";
   public Food(double proteins,double fats,double carbs,int tastyScore) {
	super(proteins,fats,carbs,tastyScore);
	this.tastyScore=tastyScore;
   }
   public Food() {
	   
	   super();
	   
   }
   
   
  @Override
public void getNutritutions() {

	System.out.println("an egg has "+this.proteins+", proteins");  
}
  public void getType()
  {
	  System.out.println(type);
  }
  public static void main(String[] args) {
	Food food=new Food(23.3,24,343,353);
	food.getNutritutions();
	Egg egg=new Food(23.3,24,343,353);
	//egg.getType();
	Egg ee=new Food();
	ee.getType();
}
}
