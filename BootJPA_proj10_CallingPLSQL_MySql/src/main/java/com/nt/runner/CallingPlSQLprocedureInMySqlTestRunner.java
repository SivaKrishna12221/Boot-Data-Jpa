package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.IEmpService;

@Component
public class CallingPlSQLprocedureInMySqlTestRunner implements CommandLineRunner
{
 @Autowired
 private IEmpService service;
 @Override
public void run(String... args) throws Exception {
	
	List<Employee> list=service.fetchEmployeeDetailsInRange(30000, 40000);
	list.forEach(System.out::println);
}
}
