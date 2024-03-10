package com.nt.entities;

import java.io.Serializable;

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
import lombok.NonNull;

@Entity
@Table(name ="jpa_mtoo_phone_numbers")
public class PhoneNumbers implements Serializable{
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "regId_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	@Column(name = "register_id")
	private Integer registerId;
	@NonNull
	@Column(name = "phone_number")
	private Long phoneNumber;
	@NonNull
	@Column(name = "provider", length = 10)
	private String provider;
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "cust_id", referencedColumnName = "cno")
	private Customer person;

	public PhoneNumbers() {
		super();
	}

	public PhoneNumbers(@NonNull Long phoneNumber, @NonNull String provider) {
		super();
		this.phoneNumber = phoneNumber;
		this.provider = provider;
		
	}

	@Override
	public String toString() {
		return "PhoneNumbers [registerId=" + registerId + ", phoneNumber=" + phoneNumber + ", provider=" + provider+"]";
				
	}

	public Integer getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Customer getPerson() {
		return person;
	}

	public void setPerson(Customer person) {
		this.person = person;
	}
}
