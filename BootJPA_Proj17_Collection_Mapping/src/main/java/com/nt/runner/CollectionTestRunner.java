package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.StationMaster;
import com.nt.repo.IStationMasterRepo;
import com.nt.service.IRailwayService;

@Component
public class CollectionTestRunner  implements CommandLineRunner{

	@Autowired
	private IRailwayService service;
	@Autowired
	private IStationMasterRepo msRepo;
	@Override
	public void run(String... args) throws Exception {
		/*LocalTime now = LocalTime.now();
		LocalTime midnight = LocalTime.of(1, 30);
		LocalTime morning = LocalTime.of(6,40);
		StationMaster st = new StationMaster("vignesh",List.of(now,midnight,morning));
		String result = service.saveStationMasterInfo(st);
		System.out.println(result);*/
		
		List<StationMaster> list = msRepo.findAll();
		list.forEach(System.out::println);
	}
	
}
