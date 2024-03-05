package com.nt.service;

import java.util.List;

import com.nt.entity.Movie;

public interface ServiceMovieInterface 
{
  public String registerMovie(Movie movie);
  public String registerGroupOfMovies(Iterable<Movie> movies);
  public Iterable<Movie> fetchAllMoviesDetails();
  public String deleteMoviesByIds(List<Integer> ids);
  public String registerMovieUsingSaveFlush(Movie movie);
   
  
}
