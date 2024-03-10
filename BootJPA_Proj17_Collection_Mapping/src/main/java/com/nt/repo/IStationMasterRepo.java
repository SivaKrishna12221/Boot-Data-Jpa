package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.StationMaster;

public interface IStationMasterRepo extends JpaRepository<StationMaster,Integer> {

}
