package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CallerTune;
import com.nt.service.IServiceCallerTune;

@Component
public class CallerTuneTestRunnerClass implements CommandLineRunner {
	@Autowired
	private IServiceCallerTune service;

	@Override
	public void run(String... args) throws Exception {
		/*CallerTune ctune=new CallerTune("cheliyaaa! cheliyaaa","Kushi");
		String tune=service.setCallerTune(ctune);
		System.out.println(tune);*/

		String msg = service.updateCallerTune(22, "nanuu nenu marchinaaa neethodu", "prema desam");
		System.out.println(msg);
		System.out.println("**************");
		CallerTune tune=service.showCallerTuneDetailsById(12);
		System.out.println(tune);
	}
}
