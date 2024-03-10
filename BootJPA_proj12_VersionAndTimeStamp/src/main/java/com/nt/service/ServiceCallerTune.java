package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CallerTune;
import com.nt.repository.CustomCollerTuneRepository;

@Service("service")
public class ServiceCallerTune implements IServiceCallerTune {
	@Autowired
	private CustomCollerTuneRepository customRepo;

	@Override
	public String setCallerTune(CallerTune tune) {
		Integer tune1 = customRepo.save(tune).getTuneId();
		return "Caller tune is added to your mobile number with id" + tune1;

	}

	@Override
	public String updateCallerTune(Integer id, String tuneName, String movieName) {
		Optional<CallerTune> opt = customRepo.findById(id);
		if (opt.isPresent()) {
			CallerTune tune = opt.get();
			tune.setMovieName(movieName);
			tune.setTuneName(tuneName);
			customRepo.save(tune);
			return "tune is updated successfully for your mobile id" + tune.getTuneId();

		}
		return "caller tune id is not present";
	}

	@Override
	public CallerTune showCallerTuneDetailsById(Integer id) {
		return customRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("id not found"));

	}
}
