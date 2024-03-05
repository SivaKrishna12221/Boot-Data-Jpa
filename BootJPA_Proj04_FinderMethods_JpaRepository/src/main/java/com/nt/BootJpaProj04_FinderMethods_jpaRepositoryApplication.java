package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.repository.CustomMovieRepository;

@SpringBootApplication
public class BootJpaProj04_FinderMethods_jpaRepositoryApplication {

	public static void main(String[] args) {
		/*	ApplicationContext ctxt = */SpringApplication.run(BootJpaProj04_FinderMethods_jpaRepositoryApplication.class,args);
		/*		
		CustomMovieRepository custRepo = ctxt.getBean("custRepo", CustomMovieRepository.class);//It will work only when we should define the bean Id.
		try {
			custRepo.findByMovieNameIs("baby").forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctxt).close();*/
	}

}
