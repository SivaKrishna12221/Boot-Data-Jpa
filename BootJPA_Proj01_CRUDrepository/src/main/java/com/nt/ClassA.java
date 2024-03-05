package com.nt;

public class ClassA 
{
  public void meth1()
  {
	  Interface1 x=(String name)->{return name;};
	  System.out.println(x.getName("siva"));
  }
  public static void main(String[] args) {
  ClassA aobj= new ClassA();
 aobj.meth1();
	
}
}
