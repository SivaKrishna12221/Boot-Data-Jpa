package com.nt.entities;

import java.io.Serializable;
import java.util.Set;

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
import lombok.NonNull;

@Entity
@Table(name = "jpa_otom_Customer")
public class Customer implements Serializable{

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "cno_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	
	private Integer cno;
	@NonNull
	@Column(name = "cust_name", length = 20)
	private String name;
	@NonNull
	@Column(name = "cust_address", length = 20)
	private String address;
	@OneToMany(targetEntity = PhoneNumbers.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "cust_id", referencedColumnName = "cno")
	private Set<PhoneNumbers> phoneNumbers;

	public Customer(@NonNull String name, @NonNull String address) {
		super();
		this.name = name;
		this.address = address;
		
	}

	public Customer() {

		super();
		System.out.println("Customer.Customer()");
	}

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<PhoneNumbers> getPhoneNumbers() {
		return phoneNumbers;
	}

	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", name=" + name + ", address"+ address + "]";
				
	}

	public void setPhoneNumbers(Set<PhoneNumbers> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
}
