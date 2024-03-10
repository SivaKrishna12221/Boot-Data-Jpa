package com.nt.service;

import java.util.Optional;

import com.nt.entity.MarriageSeekar;

public interface IMarriageService 
{
	 public String submitPersonDetails(MarriageSeekar mseeker);
	 public Optional<MarriageSeekar> showMarriageSeekarById(Integer id);
}
