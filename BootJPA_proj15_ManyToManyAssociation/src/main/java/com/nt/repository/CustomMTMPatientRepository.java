package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.MTMPatient;

public interface CustomMTMPatientRepository extends JpaRepository<MTMPatient,Integer>
{

}
