package com.nt.entity;

public class ClassEx {

	public static void main(String[] args) {
      int count=19;
      int size=3;
      int pagesize=count/size;
      if(count%size!=0)//if remainder is 0 no need to add if remainder notequal to zero we should add one
      {
    	  pagesize++;
      }
      System.out.println(pagesize);
	}

}
