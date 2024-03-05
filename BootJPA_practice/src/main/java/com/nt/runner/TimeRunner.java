package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CollerTune;
import com.nt.serviceTime.ILibrauryService;
//@Component
public class TimeRunner implements CommandLineRunner
{
	@Autowired
	private ILibrauryService service;
 @Override
public void run(String... args) throws Exception {
	/*Libraury lib= new Libraury("siva",LocalDateTime.of(2000,10,21,10,10,10), LocalDate.of(2023,07,14),LocalTime.of(10, 00));
	Libraury libraury=service.registerStudentDetails(lib);
	System.out.println(lib);
	System.out.println("one record inserted successfully");*/
	/* CollerTune tun1=new CollerTune("voni vesina dupavali ","pandemkodi");
	CollerTune tune= service.setCollerTune(tun1);
	System.out.println(tune.getTuneName()+" tune is applied successfully");
	*/
	 String result=service.getTuneInfo(111);
	 System.out.println(result);
	 
}
}
