package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service2.IDoctorService;

//@Component
class NativeSqlQueryTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {

		/*String result=	service.registerNewDoctor(208,"sathish","neurology", 85000d);
		System.out.println(result);*/
		/*String result=  service.findDate();
		System.out.println("system date:"+result);*/

	}
}
