
package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "jpa_NareshIt_studInfo")
public class NareshIt {
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "studentId_seq", initialValue = 10, allocationSize = 10)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.AUTO)

	private Integer studentId;
	@Column(name = "stud_name", length = 25)

	private String studentName;

	@Column(name = "address", length = 25)

	private String Address;
	@Column(name = "date_of_join")
	private LocalDateTime doj;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "time_of_join")
	private LocalTime toj;
	@Column(name = "fees")
	private Double fees;

	public NareshIt(String studentName, String address, LocalDateTime doj, LocalDate date, LocalTime toj, Double fees) {
		super();
		this.studentName = studentName;
		this.Address = address;
		this.doj = doj;
		this.date = date;
		this.toj = toj;
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "NareshIt [studentId=" + studentId + ", studentName=" + studentName + ", Address=" + Address + ", doj="
				+ doj + ", date=" + date + ", toj=" + toj + ", fees=" + fees + "]";
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public LocalDateTime getDoj() {
		return doj;
	}

	public void setDoj(LocalDateTime doj) {
		this.doj = doj;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getToj() {
		return toj;
	}

	public void setToj(LocalTime toj) {
		this.toj = toj;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

}
