package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.entity.Iview;
import com.nt.repository.IDoctorRepository;

@Component("serviceDoctor")
public class ServiceDoctorClasss implements ServiceDoctorInterface {
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public <T extends Iview> List<T> displayDoctorsById(Integer id, Class<T> type) {
		List<T> list = doctorRepo.searchDoctorDetailsByUsingId(id, type);
		return list;
	}

	@Override
	public List<Doctor> showDoctorsInRange(Integer range1, Integer range2) {
		List<Doctor> doctors = doctorRepo.searchDoctorsInRange(range1, range2);
		return doctors;
	}

	@Override
	public List<Doctor> fetchDoctorsWhoGettingIncomes(Iterable<Double> incomes) {

		return doctorRepo.serchDoctorsWhoGettingIncomes(incomes);
	}

	@Override
	public List<Doctor> fetchDoctorBySpecilazation(String doc) {

		return doctorRepo.searchDoctorByASpecialization(doc);
	}

	@Override
	public int countNoOfDoctor() {

		return doctorRepo.countDoctorsName();
	}

	@Override
	public Object aggregateOperationsDoctors() {

		return doctorRepo.aggregateDoctorsDeatails();
	}
	@Override
	public List<Object[]> fetchSpecifiedDoctorProperties() {
		// TODO Auto-generated method stub
		 doctorRepo.fetchListOfDoctors();
	}
}
