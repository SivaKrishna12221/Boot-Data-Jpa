package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.CustomMovieRepository;
import com.nt.resultViews.IresultView3;

//@Component
public class FinderMethodRunnerClass implements CommandLineRunner {
	@Autowired

	private CustomMovieRepository movieRepo;

	public void run(String... args) throws Exception {
		/*List<Movie> list=movieRepo.findByMovieName("baby");//if we the data is not present id doesn't show any error//here passing data is case sensitive
		list.forEach(System.out::println);
		System.out.println("=============");
		System.out.println(movieRepo.findByMovieNameAndTheatre("baby","vijetha"));
		System.out.println("==========");
		System.out.println(movieRepo.findByTicketPriceLessThanEqual(200d));
		System.out.println(movieRepo.findByMovieNameLike("b%"));
		System.out.println(movieRepo.findByMovieNameStartingWith("s"));
		System.out.println(movieRepo.findByMovieNameEqualsIgnoreCase("Baby"));
		List<Movie> list2=movieRepo.findByMovieNameContainingIgnoreCase("a");
		list2.forEach(System.out::println);*/
		/*System.out.println("static scalar projection means we should ask to hold only certain coloumns and properties, the spring data jpa generating the objects of the entity class");
		Iterable<IresultView1> result=movieRepo.findByTicketPriceBetween(100D, 250D);
		result.forEach(data->System.out.println(data.getTicketPrice()+","+data.getMovieName()));*/
		/*List<IresultView3> result=movieRepo.findByMovieCodeGreaterThanAndMovieCodeLessThan(1,5,IresultView3.class);
		result.forEach(data->System.out.println(data.getLocation()+","+data.getMovieName()+","+data.getTheatre()+","+data.getTicketPrice()));
		*/

	}
}