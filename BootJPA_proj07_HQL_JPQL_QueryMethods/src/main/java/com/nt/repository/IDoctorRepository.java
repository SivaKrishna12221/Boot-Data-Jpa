package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;
import com.nt.entity.Iview;

public interface IDoctorRepository extends JpaRepository<Doctor,Integer>
{
	@Query("from Doctor where docId=:id")
	 public <T extends Iview> List<T> searchDoctorDetailsByUsingId(Integer id,Class<T> type);
	
   @Query("FROM Doctor WHERE docId>=:range1 AND docId<=:range2")//HQL queries are independent here we need to declare Class name and properities name should be same
    List<Doctor> searchDoctorsInRange(Integer range1,Integer range2);
   @Query("From Doctor where income in(:incomes)")
   public List<Doctor> serchDoctorsWhoGettingIncomes(Iterable<Double> incomes);
   @Query("from Doctor where specialization=:doctor")
   public List<Doctor> searchDoctorByASpecialization(String doctor);
   @Query("select count(distinct doctorName) from Doctor")
   public int countDoctorsName();
   @Query("select count(*),min(income),max(income),avg(income),sum(income) from Doctor")
   public Object aggregateDoctorsDeatails();
   @Query("select doctorName,docId,specialization from Doctor ")
   public List<Object[]> fetchListOfDoctors();	
   
}
