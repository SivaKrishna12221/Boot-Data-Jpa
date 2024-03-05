package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nt.entity.Movie;
import com.nt.resultViews.IResultView;
import com.nt.resultViews.IresultView1;

public interface CustomMovieRepository extends JpaRepository<Movie, Integer> {
  public List<Movie> findByMovieName(String moviename);
  public Movie findByMovieNameAndTheatre(String mname,String theatre);
  public List<Movie> findByTicketPriceLessThanEqual(Double price);
  public List<Movie> findByMovieNameLike(String name);
  public List<Movie> findByMovieNameStartingWith(String name);
  public List<Movie> findByMovieNameEqualsIgnoreCase(String name);
  public List<Movie> findByMovieNameContainingIgnoreCase(String name);
  public Iterable<IresultView1> findByTicketPriceBetween(double price1,double price2);
  
  public <T extends IResultView> List<T> findByMovieCodeGreaterThanAndMovieCodeLessThan(Integer code1,Integer code2,Class<T> type);
  
  //query methods 
  @Query("FROM Movie WHERE ticketPrice>=:start AND ticketPrice<=:end")
  public List<Movie> showMoviesByTicketPrice(@Param("start")double start,@Param("end")double end);
  @Query("from Movie where movieName in(:m1,:m2,:m3) order by movieName ")
  public List<Movie> searchMoviesByNames( String m1, String m2,String m3);
  @Query("select movieName,ticketPrice,theatre,location from Movie where ticketPrice between :price1 and :price2")
  public List<Object[]> searchMoviesByTicketPrices(@Param("price1")Double price1,@Param("price2")Double price2);
  @Query("select movieName from Movie where ticketPrice between :price1 and :price2")
  public List<String> searchMovieNameByTicketPriceRange(@Param("price1") double price1,@Param("price2")double price2);
  @Query("select movieName,theatre,location from Movie where movieName=:mName")
  public List<Object[]> searchMovienamesAndThetresByName(@Param("mName")String mName);
  @Query("select count(movieName) from Movie")
  public String countOfMovieNames();
  @Query("select count(movieName),sum(ticketPrice),max(ticketPrice),min(ticketPrice),avg(ticketPrice) from Movie")
  public Object  aggregateMovieNames();
}
