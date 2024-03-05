package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;
import com.nt.entity.Iview;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	@Query("from Doctor where docId=:id")
	public <T extends Iview> List<T> searchDoctorDetailsByUsingId(Integer id, Class<T> type);

	@Query("FROM Doctor WHERE docId>=:range1 AND docId<=:range2") // HQL queries are independent here we need to declare
																	// Class name and properities name should be same
	public List<Doctor> searchDoctorsInRange(Integer range1, Integer range2);

	@Query("From Doctor where income in(:incomes)")
	public List<Doctor> serchDoctorsWhoGettingIncomes(Iterable<Double> incomes);

	@Query("from Doctor where specialization=:doctor")
	public List<Doctor> searchDoctorByASpecialization(String doctor);

	@Query("from Doctor where specialization in(:speci1,:speci2) order by income desc")
	public List<Doctor> searchDoctorsBySpecialization(String speci1, String speci2);

	@Query("from Doctor where income between :range1 and :range2 order by income desc")
	public List<Doctor> serchDoctorsDataByIncome(double range1, double range2);

	@Query("from Doctor where income not in(:income1,:income2,:income3) order by doctorName ")
	public List<Doctor> searchDoctorsNotGettingSIncome(double income1, double income2, double income3);
	
	/*@Query("select income ,income+:adincome newincome from Doctor where income<=:income")
	public List<Doctor> searchDoctorsByAddingIncome(double addInc,double income);
	*/
	@Query("from Doctor where doctorName=:name")
	public Doctor searchDoctorsByName(String name);
	@Query("select docId,doctorName,specialization from Doctor where docId=:code")
	public Object searchDoctorsByCode(Integer code );
	@Query("select specialization from Doctor where doctorName=:name")
	public Object searchDoctorSpecilization(String name);
	
	public <T extends Iview> Iterable<T> findBySpecializationLike(String srs,Class<T> type);
	
	public <T extends Iview> Iterable<T> findBySpecialization(String spec,Class<T> type);
}