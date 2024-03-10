package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.StationDetails;
import com.nt.entity.StationMaster;
import com.nt.entity.TrainDetails;
import com.nt.model.TrainInfo;
import com.nt.repo.IStationMasterRepo;
import com.nt.repo.ITrainRepository;

@Service("train-service")
public class TrainDetailsServiceMgmt implements IRailwayService {

	@Autowired
	private ITrainRepository trepo;
	@Autowired
	private IStationMasterRepo stRepo;

	@Override
	public String registerTrainDetails() {

		StationDetails st1 = new StationDetails("mahabub nagar");
		StationDetails st2 = new StationDetails("kurnool");

		StationDetails st3 = new StationDetails("tadipatri");

		StationDetails st4 = new StationDetails("yerraguntla");
		StationDetails st5 = new StationDetails("kadapa");
		StationDetails st6 = new StationDetails("gadwal");
		StationDetails st7 = new StationDetails("tadipatri");
		StationDetails st8 = new StationDetails("muddanur");
		StationDetails st9 = new StationDetails("kadapa");

		TrainDetails trainDetails = new TrainDetails(12575, "venkatadri express", List.of(st1, st2, st3, st4, st5));
		TrainDetails trainDetails2 = new TrainDetails(12563, "changalpattu express", List.of(st6, st7, st8, st9));
		List<TrainDetails> al = trepo.saveAll(List.of(trainDetails, trainDetails2));
		List<Integer> collect = al.stream().map(x -> x.getTrainId()).collect(Collectors.toList());
		return "train details are saved with ids" + collect;
	}

	@Override
	public void collectListOfTriansByStations() {

		List<TrainInfo> trains = trepo.fetchTrainsDetailsByStationNames();
		trains.forEach(x -> System.out.println(x.getStationName()+","+x.getTrainName()+","+","+x.getStationId()));
		
     
	}@Override
	public String saveStationMasterInfo(StationMaster stmaster) {
		
		Integer masterId = stRepo.save(stmaster).getMasterId();
		return "master info saved with id:"+masterId;
	}
}
