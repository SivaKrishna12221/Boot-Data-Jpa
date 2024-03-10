package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorInterService {
	public List<Doctor> getDetailsByRange(Double start, double end);

	public List<String> getListOfDoctorsName(String spec);

	public List<Object[]> getListOfDoctorsByLimit(double income);
	
	public List<Object[]> getListOfDoctorsAboveLimt(double income);	
}
