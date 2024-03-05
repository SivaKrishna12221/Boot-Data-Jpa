package com.nt.ssdao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Doctor;

public interface CustomDoctorRepository extends JpaRepository<Doctor,Integer>
{
	@Query(" from Doctor where name in (:args)")
	public List<Doctor> fetchListOfDoctorsUsingStringArgs(String ... args);
	
}
