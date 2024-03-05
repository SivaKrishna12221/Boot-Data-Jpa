package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.CustomDoctorRepository;

@Service("service")
public class DoctorServiceImpl implements IDoctorService
{
  @Autowired
  private CustomDoctorRepository custRepo;
  @Override
	public String deleteAllByIds(List<Integer> ids) {
	   custRepo.deleteAllById(ids);
		return ids+"are deleted successfully";
	}
  @Override
	public String deleteAllByIdsInBatch(List<Integer> ids) {
		custRepo.deleteAllByIdInBatch(ids);
		return ids+" ids are deleted successfully";
	}
  @Override
	public Iterable<Doctor> findAllById(List<Integer> ids) {
	Iterable<Doctor> docs=custRepo.findAllById(ids);
		return docs;
	}@Override
		public Optional<Doctor> findById(Integer id) {
		  Optional<Doctor> doc=custRepo.findById(id);
		if(doc.isPresent())
		{
			return doc;
		}
		else
		{
			 throw new IllegalArgumentException("id is not present");
		}
		}
	
	@Override
		public Doctor findByid(Integer id) {
			Doctor doc=custRepo.getById(id);
			return doc;
		}
  
}
