package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.nt.entity.CallerTune;

public interface CustomCollerTuneRepository
		extends CrudRepository<CallerTune, Integer>, JpaRepository<CallerTune, Integer> {

}
