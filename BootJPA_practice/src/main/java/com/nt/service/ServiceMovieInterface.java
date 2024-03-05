package com.nt.service;

import java.util.List;

import com.nt.entity.Movie;

public interface ServiceMovieInterface 
{
   public List<Movie> searchMoviesByTicketPrice(double start,double end);
   public List<Movie> showMoviesNamesInOrder(String m1,String m2,String m3);
   public List<Object[]> showMoviesByPrice(Double price1,Double price2);
   public List<String> showMovieNamesByPrice(Double price1,Double price2 );
   public List<Object[]> showMovieNamesTheatreAndLocationByName(String mname);
   public String countMovieNames();
   public Object aggregateOperationOnMovie();
   public String udpateDoctorIncome(Double income,Double hikepercentage);
}
