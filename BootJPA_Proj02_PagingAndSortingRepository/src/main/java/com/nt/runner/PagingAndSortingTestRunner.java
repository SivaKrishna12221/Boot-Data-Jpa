package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorService;

@Component
public class PagingAndSortingTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		/*Iterable<Doctor> docs=service.sortTheDoctors(true,"name");//we can also give some more properties
		docs.forEach(System.out::println);
		*/
		/*Page<Doctor> page=service.showDoctorInfoByPage(true, 3, 3, "name");
		System.out.println(page.toString());
		System.out.println("page number:"+page.getNumber());
		System.out.println("number of elements"+page.getNumberOfElements());
		System.out.println("page size:"+page.getSize());
		System.out.println("total pages:"+page.getTotalPages());
		System.out.println("is it first page:"+page.isFirst());
		System.out.println("is it last page:"+page.isLast());
		if(!page.getContent().isEmpty())
		{
			List<Doctor> list=page.getContent();
			list.forEach(System.out::println);
		}
		else
		{
			System.out.println("data is not present");
		}*/
		// service.showDataThrougPagination(4);

		Page<Doctor> page = service.fetchListOfDoctorsByPaginations(false, 1, 3, "name", "specialization");
        System.out.println("Page number:"+page.getNumber());
        System.out.println("total pages;"+page.getTotalPages());
        System.out.println("is this first page:"+page.isFirst());
        System.out.println(" is this page last:"+page.isLast());
        System.out.println("page size:"+page.getSize());
        
        List<Doctor> content = page.getContent();
        if(!content.isEmpty())
        {
        	content.forEach(System.out::println);
        }
	}
}
