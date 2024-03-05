package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.servicePlsql.IDoctorServicePlSql;
//@Component
public class PlsqlTestRunnerr implements CommandLineRunner
{
	@Autowired
	private IDoctorServicePlSql servicePlsql;
	@Override
	public void run(String... args) throws Exception {
		
		/*List<Doctor> list=servicePlsql.showDoctorDetailsByRange(70000d,100000d);
		list.forEach(System.out::println);*/
		List<String> list=servicePlsql.showDoctorNamesByRange(70000d, 100000d);
		list.forEach(System.out::println);
	}
}
