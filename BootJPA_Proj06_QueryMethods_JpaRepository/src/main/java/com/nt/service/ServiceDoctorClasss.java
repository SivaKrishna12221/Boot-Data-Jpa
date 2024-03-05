package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.entity.Iview;
import com.nt.repository.IDoctorRepository;

@Component("serviceDoctor")
public class ServiceDoctorClasss implements ServiceDoctorInterface
{
	@Autowired
    private IDoctorRepository doctorRepo;

	@Override
	public <T extends Iview> List<T> displayDoctorsById(Integer id, Class<T> type) {
		List<T> list=doctorRepo.searchDoctorDetailsByUsingId(id, type);
		return list;
	}
	@Override
	public List<Doctor> showDoctorsInRange(Integer range1, Integer range2) {
		List<Doctor> doctors=doctorRepo.searchDoctorsInRange(range1, range2);
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
    public List<Doctor> fetchDoctorsBySpecialization(String spec1, String spec2) {
    	
    return doctorRepo.searchDoctorsBySpecialization(spec1, spec2);
    }
	@Override
	public List<Doctor> fetchDoctorsByIncome(double range1, double range2) {
		
		return doctorRepo.serchDoctorsDataByIncome(range1, range2);
	}
	@Override
	public Iterable<Doctor> fetchDoctorsNotTypeIncome(double range1, double range2, double range3) {
		
		return doctorRepo.searchDoctorsNotGettingSIncome(range1, range2, range3);
	}
	/*@Override
	public List<Doctor> fetchDoctorsByAddingIncome(double addinc, double filterInc) {
		
		return doctorRepo.searchDoctorsByAddingIncome(addinc,filterInc);
	}*/
	@Override
	public Doctor fetchDoctorByName(String name) {
		
	  Doctor docs=doctorRepo.searchDoctorsByName(name);
	 
	  return docs;
	}
	@Override
	public Object fetchDoctorDetailsByCode(Integer docId) {
		
		return doctorRepo.searchDoctorsByCode(docId);
	}
	@Override
	public Object fetchSpecializationOfDoctor(String name) {
		
		return doctorRepo.searchDoctorSpecilization(name);
	}

	
	
}


