package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;

public interface IDoctorService {
	public Iterable<Doctor> sortTheDoctors(Boolean ascDesc, String... args);

	public Page<Doctor> showDoctorInfoByPage(Boolean trueOrFalse, int pageNumber, int pageSize, String... props);

	public void showDataThrougPagination(int pageSize);
	
	public Page<Doctor> fetchListOfDoctorsByPaginations(Boolean direction,Integer page,Integer size,String ... props);
}
