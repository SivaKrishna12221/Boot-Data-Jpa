package com.nt.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.CustomNareshItRepository;
import com.nt.service.INareshService;
//@Service("service")
public class NareshItServiceClass implements INareshService
{  
	@Autowired
	private CustomNareshItRepository customRepo;
@Override
public String studentRegistration(NareshIt nit) {
	NareshIt nit1=customRepo.save(nit);
	
	return "student is registered successfully";
}
}
