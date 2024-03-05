package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Movie;

//@Component("custRepo") //it required for only in main method present in spring boot application
public interface CustomMovieRepository extends JpaRepository<Movie, Integer> {
	// selct * from movie where movieName=?;
	public List<Movie> findByMovieNameIs(String name);//here moviename can declare like a property present in the entity class
	
	//select moviecode,moviename,theatre,.. from movie where movie name =?;
	public List<Movie> findByMovieNameEquals(String name);
	
	public List<Movie> findByMovieCode(int id);
	
	public List<Movie> findByTheatre(String theatre);
	
	public List<Movie> findByLocation(String loc);
	//select * from movie where moviename like 's%';
	public List<Movie> findByMovieNameStartingWith(String initchar);
	//select  * from movie where moviename like '%s';
	public List<Movie> findByMovieNameEndingWith(String Lastchar);
	//select * from movie where moviename like'%s%';
	public List<Movie> findByMovieNameContaining(String anyChar);
	//EqualsIgnoreCase
	public List<Movie> findByLocationEqualsIgnoreCase(String chars);
	
	public List<Movie> findByMovieNameLike(String chars);
	
}
