package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.entity.IResultView3;
import com.nt.service.ServiceDoctorInterface;

@Component
public class QueryMethodsForRunnerClass implements CommandLineRunner {

	@Autowired
	private ServiceDoctorInterface service;

	@Override
	public void run(String... args) throws Exception {
		List<IResultView3> list = service.displayDoctorsById(185, IResultView3.class);
		list.forEach(docs -> System.out.println(docs.getDoctorName() + "," + docs.getSpecialization()));

		List<Doctor> doctors = service.showDoctorsInRange(180, 181);
		doctors.forEach(System.out::println);
       
		List<Doctor> doctors3=service.fetchDoctorsWhoGettingIncomes(List.of(80000d,85000d,86000d,89000d));
		doctors.forEach(System.out::println);
		
	    service.fetchDoctorBySpecilazation("Ent").forEach(data->System.out.println(data.getDoctorName()+","+data.getSpecialization()));
	    
	   int count=service.countNoOfDoctor();
	   System.out.println("no.of doctors in hospital:"+count);
	   
	   Object data=service.aggregateOperationsDoctors();
	   Object[] docs=(Object[])data;
	   System.out.println("count of doctors:"+docs[0]);
	   System.out.println("min doctor income:"+docs[1]);
	   System.out.println("maximum doctor income:"+docs[2]);
	   System.out.println("average doctor income:"+docs[3]);
	   System.out.println("sum of doctor income:"+docs[4]);
	   
	 List<Object[]> listOfdocs = service.fetchSpecifiedDoctorProperties();
	   listOfdocs.forEach(x->System.out.println(x[0]+","+x[1]+","+x[2]));
	}

}
