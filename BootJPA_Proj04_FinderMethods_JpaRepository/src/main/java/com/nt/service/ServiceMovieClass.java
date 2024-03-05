package com.nt.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Movie;
import com.nt.repository.CustomMovieRepository;
@Component("serviceMovie")
public class ServiceMovieClass implements ServiceMovieInterface
{
	@Autowired
    private CustomMovieRepository movieRepo;
	@Override
	public String registerMovie(Movie movie) 
	{
		Movie mov=movieRepo.save(movie);
		return mov.getMovieCode()+" code movie is registered successfully";
	}
	@Override
	public String registerGroupOfMovies(Iterable<Movie> movies) {
		if(movies!=null) {
	     Iterable<Movie> savedmovies=movieRepo.saveAll(movies);
	     int size=((Collection)savedmovies).size();
	     return size+" movies are saved successfully";
		}else
		{
			throw new IllegalArgumentException(" movies are not found");
		}
		
	}
	@Override
	public Iterable<Movie> fetchAllMoviesDetails() {
		
		Iterable<Movie> allmovies=movieRepo.findAll();
		if(allmovies!=null)
		{
			return allmovies;
		}
		else
		{
			throw new IllegalArgumentException(" movies are not found");
		}
	}
	@Override
	public String deleteMoviesByIds(List<Integer> ids) {
	   List<Movie> movies=(List<Movie>)movieRepo.findAllById(ids);
		if(movies.size()==ids.size())
		{
			movieRepo.deleteAllById(ids);
			return movies.size()+" movies are deleted successfully";
		}
		else
		{
			throw new IllegalArgumentException("movies are not found");
		}
	}
	@Override
	public String registerMovieUsingSaveFlush(Movie movie) {
	Movie saveMovie=movieRepo.saveAndFlush(movie);
	return saveMovie.getMovieCode()+" is generated for Your movie:"+saveMovie.getMovieName();
	}

}
