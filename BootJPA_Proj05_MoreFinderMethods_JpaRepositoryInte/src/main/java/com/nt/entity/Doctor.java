package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_doctor_info2")
public class Doctor {
	@Id
	@Column(name = "doctorid")
	@SequenceGenerator(name = "seq1", sequenceName = "docId_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "seq1", strategy = GenerationType.SEQUENCE)
	private Integer docId;
	@Column(name = "doctorname", length = 25)
	private String doctorName;
	@Column(name = "specialization", length = 25)
	private String specialization;
	@Column(name = "income")
	private double income;

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", doctorName=" + doctorName + ", specialization=" + specialization
				+ ", income=" + income + "]";
	}

	public Integer getDocId() {
		return docId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public Doctor() {
		super();
	}

	public Doctor(String doctorName, String specialization, double income) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.income = income;
	}

	public double getIncome() {
		return income;
	}
}
