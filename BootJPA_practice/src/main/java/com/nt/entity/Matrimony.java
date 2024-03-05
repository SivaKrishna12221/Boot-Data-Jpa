package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.NonNull;

//@Entity
@Table(name = "jpa_matrimony")
public class Matrimony implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="person_id")
	private Integer personId;
	@Column(name="Person_name",length=20)
	private String name;
	@Column(name="person_address",length=30)
	private String address;
	@NonNull
	@Column(name="date_of_birth")
	private LocalDateTime dob;
	@Column(name="person_photo")
	@Lob
	private byte[] photo;
	@Column(name="person_bio")
	@Lob
	private char[] bio;
	public Matrimony() {
		super();
	}
	public Matrimony(String name, String address, @NonNull LocalDateTime dob, byte[] photo, char[] bio) {
		super();
		this.name = name;
		this.address = address;
		this.dob = dob;
		this.photo = photo;
		this.bio = bio;
	}
	@Override
	public String toString() {
		return "Matrimony [personId=" + personId + ", name=" + name + ", address=" + address + ", dob=" + dob + "]";
	}
	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
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
	public LocalDateTime getDob() {
		return dob;
	}
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public char[] getBio() {
		return bio;
	}
	public void setBio(char[] bio) {
		this.bio = bio;
	}
}
