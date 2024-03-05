package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;

public interface ServiceInterface {
	public String registerDoctor(Doctor doctor);

	public String registerGroupOfDoctors(Iterable<Doctor> doctors);

	public Long fetchDoctorsCount();

	public boolean checkingAvailabilityOfDoctor(int id);

	public Iterable<Doctor> showAllDoctors();

	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);

	public Doctor showSingleDoctor(Integer id);

	public String updateIncomeById(Integer id, float hikePercentage);

	public String updateOrRegister(Doctor doctor);

	// Delete operations
	public String deleteEntityById(Integer id);

	public String deleteDoctor(Doctor doctor);// delete entity.though we pass entity object it takes only id property as
												// the argu value

	public String removeAllDoctors();

	public String removeDoctorsByIds(List<Integer> ids);

	// Paging and sorting repository
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... args);

	public Page<Doctor> showDoctorsInfoByPageNo(int pageno, int pagesize, boolean asc, String props);

	public void showDataThroughPagination(int pagesize);

	// JpaRepository
	public String deleteDoctorsByIdsInBatch(List<Integer> ids);

	public Iterable<Doctor> showAllDoctorsByCrud(Iterable<Integer> ids);

	public List<Doctor> showAllDoctorsByJpa(Iterable<Integer> ids);

	// getReferenceById
	public Doctor getDoctorById(Integer id);
	
	//show doctors by Example Data
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor,boolean asc,String...props);
	
	//saveAllAndFlush method in jpaRepository
	public String  groupOfDoctorsRegistration(List<Doctor> docs);
	
	public List<Doctor> getListOfDocs(String ...args);
}
