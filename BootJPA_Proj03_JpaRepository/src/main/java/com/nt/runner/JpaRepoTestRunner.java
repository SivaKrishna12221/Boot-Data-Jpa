package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorService;

@Component
public class JpaRepoTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorService service;

	@Override
	public void run(String... args) throws Exception {

		/*String result=service.deleteAllByIds(List.of(null,202));
		System.out.println(result);*/
		/*String result=service.deleteAllByIdsInBatch(Arrays.asList(202,100,null));
		System.out.println(result);*/
		/* Iterable<Doctor> list=service.findAllById(List.of(100,200,197,203));
		 list.forEach(System.out::println);*/
		/*Optional<Doctor> opt = service.findById(202);
		System.out.println(opt.get());*/
		/*Doctor doc=service.findByid(203);
		System.out.println(doc);*/

	}
}
