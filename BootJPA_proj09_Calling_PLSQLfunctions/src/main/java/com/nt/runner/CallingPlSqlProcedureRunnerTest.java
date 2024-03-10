package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorInterService;

@Component
public class CallingPlSqlProcedureRunnerTest implements CommandLineRunner {

	@Autowired
	private IDoctorInterService service;

	@Override
	public void run(String... args) throws Exception {
		service.getDetailsByRange(80000d, 90000).forEach(System.out::println);
         System.out.println("=====******************==========");   
		service.getListOfDoctorsName("neurology").forEach(System.out::println);
	    System.out.println("=====******************==========");   
			
	List<Object[]> list = service.getListOfDoctorsByLimit(80000);

		for(Object[] obj1:list)
		{
			String s1=(String)obj1[0];
			String s2=(String)obj1[1];
			System.out.println(s1+","+s2);
		}
	    System.out.println("=====******************==========");   
		
		List<Object[]> doctors = service.getListOfDoctorsAboveLimt(100000);
		for(Object[] obj:doctors)
		{
		  String s1=(String)obj[0];
		  String s2=(String)obj[1];
		  System.out.println(s1+","+s2);
		}
	}
}
