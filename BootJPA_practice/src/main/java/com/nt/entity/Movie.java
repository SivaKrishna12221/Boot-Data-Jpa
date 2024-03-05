package com.nt.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
//@Entity
@Table(name="jpa_Movie")
public class Movie {
	@Id
	@SequenceGenerator(name="seq1",sequenceName="Movie_Code_Seq",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="seq1" ,strategy=GenerationType.SEQUENCE)
	@Column(name = "Movie_Code",length=20)
    private Integer movieCode;
	@Column(name = "movie_name",length=20)
	private String movieName;
	@Column(name = "Theatre",length=20)
	private String theatre;
	@Column(name = "location",length=20)
	private String location;
	@Column(name = "ticket_price")
	private Double ticketPrice;

	@Override
	public String toString() {
		return "Movie [movieCode=" + movieCode + ", movieName=" + movieName + ", theatre=" + theatre + ", location="
				+ location + ", ticketPrice=" + ticketPrice + "]";
	}

	public Integer getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(Integer movieCode) {
		this.movieCode = movieCode;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatre() {
		return theatre;
	}

	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Movie(String movieName, String theatre, String location, Double ticketPrice) {
		super();
		this.movieName = movieName;
		this.theatre = theatre;
		this.location = location;
		this.ticketPrice = ticketPrice;
	}
	public Movie()
	{
		
	}
}
