package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nt.entity.MarriageSeekar;

public interface CustomMarraiageRepository extends JpaRepository<MarriageSeekar,Integer>
{ 
 
}
