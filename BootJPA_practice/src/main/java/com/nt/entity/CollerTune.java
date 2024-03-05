package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

//@Entity
@Table(name = "jpa_coller_tune2")
public class CollerTune {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "tuneId_sequence", initialValue = 100, allocationSize = 10)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	@Column(name="tune_id")
	private Integer tuneId;
	@Column(name = "tune_Name", length = 30)
	private String tuneName;
	@Column(name = "movie_name", length = 20)
	private String movieName;
	@Version
	private Integer countUpdate;
    @CreationTimestamp
	private LocalDateTime lastlyUpdated;
    @UpdateTimestamp
	private LocalDateTime lastlySaved;
	public CollerTune(String tuneName, String movieName) {
		super();
		this.tuneName = tuneName;
		this.movieName = movieName;
	}
	
	@Override
	public String toString() {
		return "CollerTune [tuneId=" + tuneId + ", tuneName=" + tuneName + ", movieName=" + movieName + ", countUpdate="
				+ countUpdate + ", lastlyUpdated=" + lastlyUpdated + ", lastlySaved=" + lastlySaved + "]";
	}
	
	public Integer getTuneId() {
		return tuneId;
	}
	public CollerTune() {
		super();
	}

	public void setTuneId(Integer tuneId) {
		this.tuneId = tuneId;
	}
	public String getTuneName() {
		return tuneName;
	}
	public void setTuneName(String tuneName) {
		this.tuneName = tuneName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getCountUpdate() {
		return countUpdate;
	}
	public void setCountUpdate(Integer countUpdate) {
		this.countUpdate = countUpdate;
	}
	public LocalDateTime getLastlyUpdated() {
		return lastlyUpdated;
	}
	public void setLastlyUpdated(LocalDateTime lastlyUpdated) {
		this.lastlyUpdated = lastlyUpdated;
	}
	public LocalDateTime getLastlySaved() {
		return lastlySaved;
	}
	public void setLastlySaved(LocalDateTime lastlySaved) {
		this.lastlySaved = lastlySaved;
	}
	

}
