package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.CustomDoctorRepository;

@Service("service")
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private CustomDoctorRepository custRepo;

	@Override
	public Iterable<Doctor> sortTheDoctors(Boolean trueOrFalse, String... props) {

		Sort sorting = Sort.by(trueOrFalse ? Direction.ASC : Direction.DESC, props);
		Iterable<Doctor> docSortOrder = custRepo.findAll();
		return docSortOrder;
	}

	@Override
	public Page<Doctor> showDoctorInfoByPage(Boolean trueOrFalse, int pageNumber, int pageSize, String... props) {
		Sort sorting = Sort.by(trueOrFalse? Direction.ASC : Direction.DESC, props);// here we are sorting the records
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sorting);//here we are assigning the records page by page
		Page<Doctor> page = custRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showDataThrougPagination(int pageSize) {
		long count = custRepo.count();
		long countPages = count / pageSize;
		if (count % pageSize != 0) {
			countPages++;
		}
		for(int i=0;i<=countPages;i++)
		{
			Pageable pageable=PageRequest.of(i, pageSize);
			Page page=custRepo.findAll(pageable);
			List<Doctor> list=page.getContent();
			list.forEach(System.out::println);
		}
	}
	@Override
	public Page<Doctor> fetchListOfDoctorsByPaginations(Boolean dir,Integer page, Integer size,String...props) {
		
	//first we have to sort operation using sort class
		Sort sort = Sort.by(dir?Direction.ASC:Direction.DESC, props);
		Pageable pageable = PageRequest.of(page, size,sort);
	    Page<Doctor> pages = custRepo.findAll(pageable);
	    return pages;
	}
}