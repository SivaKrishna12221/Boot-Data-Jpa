package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ServiceMovieInterface;

//@Component
public class QueryMethodTestRunner implements CommandLineRunner {
	@Autowired
	private ServiceMovieInterface service;

	@Override
	public void run(String... args) throws Exception {
		/*List<Movie>  list= service.searchMoviesByTicketPrice(100, 250);
		list.forEach(System.out::println);*/
		/*List<Movie> list2=service.showMoviesNamesInOrder("baby","maveeran","samajavaragamana");
		list2.forEach(System.out::println);*/

		/*service.showMoviesByPrice(100d,200d).forEach(data -> {
		         for(Object row:data)//in data contain all list of records with certain 
		         {
		        	 System.out.print(row+",");//retrieve each property
		         }
		       System.out.println();
		});*/
		/*service.showMovieNamesTheatreAndLocationByName("baby").forEach(data->
		{
			for(Object movieInfo:data)//data represents first records// movieInfo represent properties
			{
				System.out.print(movieInfo+",");
			}
			System.out.println();
		}
		);*/
		/*String result=service.countMovieNames();
		System.out.println(result);*/
	   Object[] obj=(Object[])service.aggregateOperationOnMovie();
	   System.out.println("count:"+obj[0]);
	   System.out.println("sum of ticketPrice:"+obj[1]);
	   System.out.println("min ticketprice:"+obj[2]);
	   System.out.println("max ticketprice:"+obj[3]);
	   System.out.println("avg ticketprice:"+obj[4]);
	   
	}

}
