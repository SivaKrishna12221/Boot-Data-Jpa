package com.nt.srunner2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.ssdao.CustomDoctorRepository;
import com.nt.sservice2.IDoctorService;

@Component
public class DoctorTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorService docService;
	@Autowired
	private CustomDoctorRepository repo;

	@Override
	public void run(String... args) throws Exception {
		/*Doctor doc1=new Doctor("siva","Meternory",75000d);
		Doctor doc2=new Doctor("kalyani","Cardiology",78000d);
		Doctor doc3=new Doctor("siri","Anesthisiology",81000d);
		String result=docService.registerGroupOfDoctors(List.of(doc1,doc2,doc3));
		System.out.println(result);*/
		/*System.out.println(docService.checkTheDoctorById(201));*/
		/*System.out.println(docService.countNumberOfDoctors());*/
		/* Doctor doc1=new Doctor();
		 doc1.setIncome(75000d);
		 Example ex=Example.of(doc1);
		 List<Doctor> doc=repo.findAll(ex);
		 doc.forEach(System.out::println);*/

		List<Doctor> docs = repo.fetchListOfDoctorsUsingStringArgs("siva", "sudharshan");
		docs.forEach(System.out::println);
	}
}
