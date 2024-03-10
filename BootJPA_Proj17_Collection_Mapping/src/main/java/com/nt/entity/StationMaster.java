package com.nt.entity;

import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.ListIndexBase;
import org.springframework.lang.NonNull;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="jpa_collection_station_master")
@Data
@NoArgsConstructor
public class StationMaster {

	@Id
	@GeneratedValue
	private Integer masterId;
	@Column(length=30)
	@NonNull
	private String name;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="master_shifts",joinColumns = @JoinColumn(name="ms_id",referencedColumnName ="masterId"))
	@OrderColumn(name="shift_order")
	@ListIndexBase(value=1)
	@Column(name="ms_shifts",length=30)
	@NonNull
	private List<LocalTime> shifts;		
	
}
