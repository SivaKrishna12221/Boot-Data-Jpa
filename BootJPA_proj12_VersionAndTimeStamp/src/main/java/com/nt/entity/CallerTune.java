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

@Entity
@Table(name = "jpa_caller_tune")
public class CallerTune {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "tuneId_seq", initialValue = 2, allocationSize = 10)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.AUTO)
	private Integer tuneId;
	@Column(name = "tune_name", length = 30)
	private String tuneName;

	@Column(name = "movie_name", length = 20)
	private String movieName;
	@Column(name = "updated_count", length = 3)
	@Version
	private Integer updatedTimes;
	@Column(name = "service_opted_on", length = 35)
	@CreationTimestamp
	private LocalDateTime serviceOptedOn;
	@Column(name = "lastly_updated", length = 35)
	@UpdateTimestamp
	private LocalDateTime lastlyUpdated;

	public CallerTune(String tuneName, String movieName) {
		super();
		this.tuneName = tuneName;
		this.movieName = movieName;
	}

	public CallerTune() {
		super();
	}

	@Override
	public String toString() {
		return "CallerTune [tuneId=" + tuneId + ", tuneName=" + tuneName + ", movieName=" + movieName
				+ ", updatedTimes=" + updatedTimes + ", serviceOptedOn=" + serviceOptedOn + ", lastlyUpdated="
				+ lastlyUpdated + "]";
	}

	public Integer getTuneId() {
		return tuneId;
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

	public Integer getUpdatedTimes() {
		return updatedTimes;
	}

	public void setUpdatedTimes(Integer updatedTimes) {
		this.updatedTimes = updatedTimes;
	}

	public LocalDateTime getServiceOptedOn() {
		return serviceOptedOn;
	}

	public void setServiceOptedOn(LocalDateTime serviceOptedOn) {
		this.serviceOptedOn = serviceOptedOn;
	}

	public LocalDateTime getLastlyUpdated() {
		return lastlyUpdated;
	}

	public void setLastlyUpdated(LocalDateTime lastlyUpdated) {
		this.lastlyUpdated = lastlyUpdated;
	}

}
