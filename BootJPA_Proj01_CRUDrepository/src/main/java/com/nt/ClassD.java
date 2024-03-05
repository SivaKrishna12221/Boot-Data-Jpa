package com.nt;

import java.util.Optional;

public class ClassD {
 /*
  * Java announced a new class optional .in jdk8 whic is used to deal 
  * with Null pointer exception in our program
  * 
  * It is public final class which is present in java.util package
  * 
  * Optional class offers methods which is used to check the null value present or not
  */
	public void meth1()
	{
		String s1[]=new String[5];
		s1[0]="kishan";
		s1[1]="ram";
		s1[2]="siva";
	    Optional<String> o=Optional.ofNullable(s1[2]);
	    System.out.println(o);
	    if(o.isPresent())
	    {
	    	System.out.println("Data is present");
	    	System.out.println(o.get());
	    }
	    else
	    {
	    	System.out.println("its Empty");
	    }
	}
	public static void main(String[] args) {
		new ClassD().meth1();
	}
}
