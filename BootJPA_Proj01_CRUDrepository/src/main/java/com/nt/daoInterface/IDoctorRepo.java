package com.nt.daoInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Doctor;

public interface IDoctorRepo extends CrudRepository<Doctor,Integer>,PagingAndSortingRepository<Doctor,Integer> ,JpaRepository<Doctor,Integer>{
	
	
}
