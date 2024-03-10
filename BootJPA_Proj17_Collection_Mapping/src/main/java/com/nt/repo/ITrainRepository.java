package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.TrainDetails;
import com.nt.model.TrainInfo;

public interface ITrainRepository extends JpaRepository<TrainDetails, Integer>{

	@Query("select new com.nt.model.TrainInfo(s.stationId,s.stationName,t.trainNo,t.trainName) from TrainDetails t inner join StationDetails s on t.trainId=s.td.trainId")
	public List<TrainInfo> fetchTrainsDetailsByStationNames();
}
