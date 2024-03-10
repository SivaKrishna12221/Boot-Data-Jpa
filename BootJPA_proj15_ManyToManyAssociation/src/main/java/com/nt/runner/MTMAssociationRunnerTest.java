package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IMTMService;
@Component
public class MTMAssociationRunnerTest implements CommandLineRunner
{
	@Autowired
	private IMTMService service;
@Override
public void run(String... args) throws Exception {
	//service.saveDoctorData();
	//service.saveDataUsinPatient();
	//service.loadDataUsingDoctor();
	service.loadDataUsingPatient();
}
}
