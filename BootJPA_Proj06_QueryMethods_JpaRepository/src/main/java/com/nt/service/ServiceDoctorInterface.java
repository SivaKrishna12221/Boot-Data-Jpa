package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;
import com.nt.entity.Iview;

public interface ServiceDoctorInterface {
	public <T extends Iview> List<T> displayDoctorsById(Integer id, Class<T> type);

	public List<Doctor> showDoctorsInRange(Integer range1, Integer range2);

	public List<Doctor> fetchDoctorsWhoGettingIncomes(Iterable<Double> incomes);

	public List<Doctor> fetchDoctorBySpecilazation(String doc);

	public List<Doctor> fetchDoctorsBySpecialization(String spec1, String spec2);

	public List<Doctor> fetchDoctorsByIncome(double range1, double range2);

	public Iterable<Doctor> fetchDoctorsNotTypeIncome(double range1, double range2, double range3);

	// public List<Doctor> fetchDoctorsByAddingIncome(double addinc,double
	// filterInc);
	public Doctor fetchDoctorByName(String name);
	
	public Object fetchDoctorDetailsByCode(Integer docId);
	
	public Object fetchSpecializationOfDoctor(String name);
	
	
}
