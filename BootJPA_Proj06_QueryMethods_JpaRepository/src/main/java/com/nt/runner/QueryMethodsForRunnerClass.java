package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.entity.IResultView2;
import com.nt.entity.IResultView3;
import com.nt.repository.IDoctorRepository;
import com.nt.service.ServiceDoctorInterface;

@Component
public class QueryMethodsForRunnerClass implements CommandLineRunner {

	@Autowired
	private ServiceDoctorInterface service;
	
	@Autowired
	private IDoctorRepository  docRepo;

	@Override
	public void run(String... args) throws Exception {
		List<IResultView3> list = service.displayDoctorsById(185, IResultView3.class);
		list.forEach(docs -> System.out.println(docs.getDoctorName() + "," + docs.getSpecialization()));
		
		List<Doctor> doctors = service.showDoctorsInRange(180, 181);
		doctors.forEach(System.out::println);
		
		List<Doctor> doctors3=service.fetchDoctorsWhoGettingIncomes(List.of(80000d,85000d,86000d,89000d));
		doctors.forEach(System.out::println);
		
		service.fetchDoctorBySpecilazation("Ent").forEach(data->System.out.println(data.getDoctorName()+","+data.getSpecialization()));
		
		service.fetchDoctorsBySpecialization("Anesthesiology","Psychiatry").forEach(System.out::println);
		
		service.fetchDoctorsByIncome(70000, 90000).forEach(System.out::println);
		
		service.fetchDoctorsNotTypeIncome(85000,87000,90000).forEach(System.out::println);
		
		//service.fetchDoctorsByAddingIncome(5500,80000).forEach(System.out::println);
		
		 Doctor doc= service.fetchDoctorByName("Jyothi");
		  System.out.println(doc);
		Object obj=service.fetchDoctorDetailsByCode(185);
		Object docsc[]=(Object[])obj;
		for(Object columns:docsc)
		{
		   System.out.print(columns+",");
		}
		System.out.println();
		
		Object data=service.fetchSpecializationOfDoctor("Keerthi");
		System.out.println("specialization:"+data);
		
		docRepo.findBySpecializationLike("P%",IResultView2.class).forEach(x->System.out.println(x.getDoctorName()+","+x.getIncome()+","+x.getSpecialization()));
	}

}
