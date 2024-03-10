package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Doctor;

public interface IDoctorRepo extends JpaRepository<Doctor, Integer>{

	@Procedure(name="GET_DOCTOR_DETAILS_BY_RANGE")
	public List<Doctor> getDocs(@Param("start_income") double sal1,@Param("end_income") double sal2,@Param("details") Class<Doctor> cls );
}
