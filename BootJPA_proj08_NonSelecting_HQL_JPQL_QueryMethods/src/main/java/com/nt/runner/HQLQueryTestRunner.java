package com.nt.runner;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ServiceDoctorInterface;

@Component
public class HQLQueryTestRunner implements CommandLineRunner {
	@Autowired
	private ServiceDoctorInterface service;

	@Override
	public void run(String... args) throws Exception {
		/*int count=service.appraiseDoctorsIncomeBySpecilization("Psychiatry", 15.0f);
		System.out.println(count+" no.of doctors get hikes");*/
		/*int count=service.fireDoctorsByIncomeRange(0, 10000);
		System.out.println(count+" no.of doctors are fired");
		*/
		/*int count= service.updateDoctorsIncomeByIds(193,194,86000);
		System.out.println(count+" records are updated successfully");*/
		/* String msg=service.addingNewDoctorData("Gowthami","Pshycology", 83000d);
		 System.out.println(msg);*/
		/*String result=service.displaySystemDate();
		System.out.println("today :"+result);
		*/
		int count = service.createTableWithQueryMethod();
		if (count == 0) {
			System.out.println("table is reated");
		} else {
			System.out.println("table is not creted");
		}
	}
}
