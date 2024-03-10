package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainInfo {
	private Integer stationId;
	private String stationName;

	private Integer trainNumber;
	
	private String trainName;
}