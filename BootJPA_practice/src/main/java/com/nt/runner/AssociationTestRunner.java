package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.serviceAssociation.IOntToManyService;

@Component
public class AssociationTestRunner implements CommandLineRunner {
	@Autowired
	private IOntToManyService service;

	@Override
	public void run(String... args) throws Exception {
		service.registerSchoolAndTeacherData();

	}
}
