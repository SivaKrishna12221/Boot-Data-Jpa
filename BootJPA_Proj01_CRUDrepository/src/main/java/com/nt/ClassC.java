package com.nt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClassC
{ 
  public void meth1()
  {
	  ArrayList<String> al=new ArrayList<String>();
	  al.add("siva");
	  al.add("ram");
	  al.add("sitha");
	  al.add("ravi");
	  al.add("rajesh");
	  System.out.println(al);
	  al.forEach(data->System.out.print(data+","));
	  Stream<String> st1=al.stream();
	  Stream<String> st2=st1.filter(data->data.length()<4);
	  long count=st2.count();
	  System.out.println(count);
	  System.out.println("num:"+al.stream().filter(data->data.length()<5).count());
	  List<String> li=al.stream().sorted().collect(Collectors.toList());
	  System.out.println(li);
	  List<String> lis=al.stream().sorted().collect(Collectors.toList());
	  System.out.println(lis);
	  System.out.println("map stream");
	  ArrayList<Integer> al1=new ArrayList<Integer>();
	  al1.add(23);
	  al1.add(43);
	  al1.add(34);
	  al1.add(32);
	  al1.add(65);
	  List<Integer> list=al1.stream().map(data->data).collect(Collectors.toList());
	  System.out.println(list);
  }
  public static void main(String[] args) {
	new ClassC().meth1();
}
}
