package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.NareshIt;
import com.nt.repository.CustomNareshItRepository;

@Service("service")
public class NareshItServiceClass implements INareshService {
	@Autowired
	private CustomNareshItRepository customRepo;

	@Override
	public String studentRegistration(NareshIt nit) {
		NareshIt nit1 = customRepo.save(nit);

		return "student is registered successfully";
	}
}
