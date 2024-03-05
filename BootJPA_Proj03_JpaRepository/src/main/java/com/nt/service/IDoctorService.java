package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public String deleteAllByIds(List<Integer> ids);

	public String deleteAllByIdsInBatch(List<Integer> ids);

	public Iterable<Doctor> findAllById(List<Integer> ids);

	public Optional<Doctor> findById(Integer id);

	public Doctor findByid(Integer id);
}
