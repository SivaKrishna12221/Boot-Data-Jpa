package com.nt.service;

import com.nt.entity.StationMaster;

public interface IRailwayService {

	public String registerTrainDetails();
	
	public void  collectListOfTriansByStations();
	
	public String saveStationMasterInfo(StationMaster stmaster);
}
