package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeekar;
import com.nt.repository.CustomMarraiageRepository;

@Service("service")
public class MarriageServiceImpl implements IMarriageService {
	@Autowired
	private CustomMarraiageRepository custoRepo;

	@Override
	public String submitPersonDetails(MarriageSeekar mseeker) {
		MarriageSeekar mseekar = custoRepo.save(mseeker);
		return "seekar is added to the matrimony with id:" + mseekar.getId();
	}

	@Override
	public Optional<MarriageSeekar> showMarriageSeekarById(Integer id) {

		return custoRepo.findById(id);
	}
}
