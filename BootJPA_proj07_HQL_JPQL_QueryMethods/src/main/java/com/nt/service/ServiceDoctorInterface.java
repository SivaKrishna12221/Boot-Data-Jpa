package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;
import com.nt.entity.Iview;

public interface ServiceDoctorInterface {
	public <T extends Iview> List<T> displayDoctorsById(Integer id, Class<T> type);

	public List<Doctor> showDoctorsInRange(Integer range1, Integer range2);
	
	public List<Doctor> fetchDoctorsWhoGettingIncomes(Iterable<Double> incomes);
	
	public List<Doctor> fetchDoctorBySpecilazation(String doc);
	
	public int countNoOfDoctor();
	
	public Object aggregateOperationsDoctors();
	
	public List<Object[]> fetchSpecifiedDoctorProperties();
}
