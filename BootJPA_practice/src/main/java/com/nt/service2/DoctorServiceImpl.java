package com.nt.service2;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.CustomDoctorRepository;

@Service("doctorService")
public class DoctorServiceImpl implements IDoctorService
{ @Autowired
	private CustomDoctorRepository doctorRepo;
 @Override
public String registerNewDoctor(Integer docid, String name, String specialization, Double income) {
	int count=doctorRepo.registerDoctor(docid, name, specialization, income);
	return count==0?"doctor is not registered":"doctor is registered";
}
 @Override
	public String findDate() {
		return doctorRepo.findDate();
	}
}
