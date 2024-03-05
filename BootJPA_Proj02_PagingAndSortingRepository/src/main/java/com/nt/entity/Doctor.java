package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_doctor_info2") // here name is not case sensitive
public class Doctor {
	@Column(name = "doctor_id") // here also name is not case sensitive but it should not be changed because it
								// is a
								// primary key
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "DOCID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE) // AUTO should be capital,,for every
	// compilation one row is created // .
	private Integer docId;
	@Column(name = "doctor_name", length = 25) // IF we change name new column will generate
	private String name;
	@Column(name = " specialization", length = 20) // If we change name one new column will create
	private String specialization;
	// @Transient//if you declare Transient we can't save the data
	// Mainly the Transient is used if we don't want to save the personal info of
	// particular person then we make the property as transient
	@Column(name = "income")
	private Double income;

	public Doctor(String name, String specialization, Double income) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.income = income;
	}

	public Doctor() {
		super();
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", name=" + name + ", specialization=" + specialization + ", income=" + income
				+ "]";
	}
}
