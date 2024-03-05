package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.CustomMovieRepository;

@Component
public class FinderMethodRunnerClass implements CommandLineRunner {

	@Autowired
	private CustomMovieRepository movieRepo;

	@Override
	public void run(String... args) throws Exception {
		movieRepo.findByMovieNameIs("baby").forEach(System.out::println);
		System.out.println("====================");
		movieRepo.findByMovieNameEquals("samajavaragamana").forEach(System.out::println);
		System.out.println("=====================");
		movieRepo.findByMovieCode(2).forEach(System.out::println);
		System.out.println("========by theatre===");
		movieRepo.findByTheatre("inox").forEach(System.out::println);
		System.out.println("================");
		movieRepo.findByLocation("kukatpalli").forEach(System.out::println);
		System.out.println("======starating with=====");
		movieRepo.findByMovieNameStartingWith("b").forEach(System.out::println);
		System.out.println("======ending with====");
		movieRepo.findByMovieNameEndingWith("a").forEach(System.out::println);
		System.out.println("=======containing====");
		movieRepo.findByMovieNameContaining("g").forEach(System.out::println);
		System.out.println("=======EqualsIgnoreCase====");
		movieRepo.findByLocationEqualsIgnoreCase("balaNagAr").forEach(System.out::println);
		System.out.println("========like===");
		movieRepo.findByMovieNameLike("%s%").forEach(System.out::println);
		
		
	}
}
