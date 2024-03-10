package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.nt.entity.NareshIt;
import com.nt.service.INareshService;

public class WorkWithDateAndTimeRunnerClass implements CommandLineRunner {
	@Autowired
	private INareshService service;

	public void run(String... args) {
		NareshIt nit = new NareshIt("siva", "kadapa", LocalDateTime.of(2022, 9, 5, 9, 30, 15), LocalDate.now(),
				LocalTime.now(), 12000d);
		String results = service.studentRegistration(nit);
		System.out.println(results);
	}
}
