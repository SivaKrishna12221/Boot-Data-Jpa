package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.entity.Movie;
import com.nt.repository.CustomDoctorRepository;
import com.nt.repository.CustomMovieRepository;

@Service("serviceMovie")
public class ServiceMovieClass implements ServiceMovieInterface {
	@Autowired
	private CustomMovieRepository movieRepo;
	@Autowired
	private CustomDoctorRepository doctorRepo;

	@Override
	public List<Movie> searchMoviesByTicketPrice(double start, double end) {
		List<Movie> list = movieRepo.showMoviesByTicketPrice(start, end);
		return list;
	}

	@Override
	public List<Movie> showMoviesNamesInOrder(String m1, String m2, String m3) {
		List<Movie> list = movieRepo.searchMoviesByNames(m1, m2, m3);
		return list;
	}

	@Override
	public List<Object[]> showMoviesByPrice(Double price1, Double price2) {
		List<Object[]> listOfObjects = movieRepo.searchMoviesByTicketPrices(price1, price2);// from this line we will
																							// get list of records with
																							// certain properties
		return listOfObjects;
	}

	@Override
	public List<String> showMovieNamesByPrice(Double price1, Double price2) {
		List<String> list = movieRepo.searchMovieNameByTicketPriceRange(price1, price2);
		return list;
	}

	@Override
	public List<Object[]> showMovieNamesTheatreAndLocationByName(String mname) {
		List<Object[]> list = movieRepo.searchMovienamesAndThetresByName(mname);
		return list;
	}

	@Override
	public String countMovieNames() {
		return movieRepo.countOfMovieNames();
	}

	@Override
	public Object aggregateOperationOnMovie() {
		Object movieDetails = movieRepo.aggregateMovieNames();
		return movieDetails;
	}

	@Override
	public String udpateDoctorIncome(Double income, Double hikepercentage) {
		Iterable<Doctor> doctors = doctorRepo.updateDoctorIncome(income, hikepercentage);
		int count = ((Collection) doctors).size();
		List<Integer> list = new ArrayList();
		doctors.forEach(id -> list.add(id.getDocId()));
		return count + "no.of doctors income  is increased with their ids" + list.toString();
	}
}
