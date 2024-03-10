package com.nt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "train_details7")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class TrainDetails {

	@Id
	@SequenceGenerator(name = "gen7", sequenceName  = "tns_seq7", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator="gen7",strategy = GenerationType.SEQUENCE)
	private Integer trainId;
    @NonNull
	private Integer trainNo;
	@Column(length = 20)
	@NonNull
	private String trainName;

	/*@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "station_info2", joinColumns = @JoinColumn(name = "st_id", referencedColumnName = "trainId"))
	@OrderColumn(name = "station_index")
	@ListIndexBase(value = 1)
	@Column(name="station_name",length=30)
	@NonNull*/
	@OneToMany(targetEntity = StationDetails.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="tn_id", referencedColumnName = "trainId")
	@NonNull
	private List<StationDetails> stationNames;

}
