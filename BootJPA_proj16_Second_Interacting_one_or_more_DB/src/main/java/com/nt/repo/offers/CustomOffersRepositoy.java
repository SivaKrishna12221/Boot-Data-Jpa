package com.nt.repo.offers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.offers.Offers;

public interface CustomOffersRepositoy extends JpaRepository<Offers,Integer>
{
  
}
