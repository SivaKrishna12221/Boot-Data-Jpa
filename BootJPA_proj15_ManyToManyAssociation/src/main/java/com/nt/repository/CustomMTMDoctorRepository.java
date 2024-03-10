package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.MTMDoctor;

public interface CustomMTMDoctorRepository extends JpaRepository<MTMDoctor,Integer>
{

}
