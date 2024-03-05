package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ServiceMovieInterface;

//@Component
public class HQLAndJPQLqueryTestRunner implements CommandLineRunner {
	@Autowired
	private ServiceMovieInterface service;

	@Override
	public void run(String... args) throws Exception {
		String result = service.udpateDoctorIncome(80000d, 23d);
		System.out.println(result);
	}
}
