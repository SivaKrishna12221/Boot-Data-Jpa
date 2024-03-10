package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entities.PhoneNumbers;

public interface IPhoneNumberRepository extends JpaRepository<PhoneNumbers,Integer>{

}
