package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="station_details7")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StationDetails {

	@Id
	@SequenceGenerator(name="gen7",sequenceName = "stn_id7",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen7",strategy = GenerationType.SEQUENCE)	
	private Integer stationId;
	@Column(length=20,name="station_name")
	@NonNull
	private String stationName;

	@ManyToOne(targetEntity=TrainDetails.class,cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="tn_id", referencedColumnName = "trainId")
	private TrainDetails td;
}
