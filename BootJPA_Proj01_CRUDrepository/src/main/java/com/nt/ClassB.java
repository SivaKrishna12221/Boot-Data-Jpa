package com.nt;

import java.util.ArrayList;
import java.util.Iterator;

public class ClassB 
{
  public void meth1()
  {
 ArrayList<Integer> al=new ArrayList<Integer>();
  al.add(62);
  al.add(13);
  al.add(43);
  al.add(42);
  al.add(34);
  
  System.out.println(al);
  Iterator<Integer> i= al.iterator();
  while(i.hasNext())
  {
	  System.out.print(i.next()+",");
  }
  al.forEach(data->System.out.print(data+","));
}
  public static void main(String[] args) {
	new ClassB().meth1();
}
}