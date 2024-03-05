package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.entity.IResultView;
import com.nt.entity.IResultView1;
import com.nt.entity.IResultView2;
import com.nt.entity.IResultView3;
import com.nt.repository.IDoctorRepository;

@Component
public class FinderMethodsRunnerClass implements CommandLineRunner
{
    @Autowired
	private IDoctorRepository  doctorRepo;
	@Override
	public void run(String... args) throws Exception {
	 System.out.println("=====And====");
     Iterable<Doctor> doctors=  doctorRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(80000,90000);
	  doctors.forEach(System.out::println);
	  System.out.println("====InOr=====");
	 List<Doctor> doctors2= doctorRepo.findBySpecializationInOrIncomeBetween(List.of("Psychiatry","Anesthisiology"),90000,85000);
	  doctors.forEach(System.out::println);
	  System.out.println("=====using result view interface==");
	  System.out.println("we can get our wish specific properties");
	  List<IResultView> doctors3=doctorRepo.findBySpecializationIn(List.of("Psychiatry","Anesthisiology"));
	  doctors3.forEach(data->System.out.println(data.getDoctorName()+","+data.getSpecialization()));
	  System.out.println("specifying dynamic properties");
	  Iterable<IResultView2> doctors4=doctorRepo.findByIncomeBetween(85000,90000,IResultView2.class);
	  doctors4.forEach(docs->System.out.println(docs.getDoctorName()+","+docs.getSpecialization()+","+docs.getIncome()));
	  Iterable<IResultView1> doctors5=doctorRepo.findByDocIdBetween(180,190,IResultView1.class);
	  doctors5.forEach(docs->System.out.println(docs.getDoctorName()+","+docs.getSpecialization()+","+docs.getClass()));
	  System.out.println("getting the records by passing the details by docIds");
	  doctorRepo.findByDocIdIn(List.of(180,181,182,200),IResultView3.class).forEach(docs->System.out.println(docs.getDocId()+","+docs.getDoctorName()+","+docs.getSpecialization()+","+docs.getIncome()));
	}
 
}
