package com.nt.entity;

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

@Entity
@Table(name="jpa_Teachers_info")
public class Teachers implements Serializable	
{
 @Id
 @SequenceGenerator(name="gen1",sequenceName="tid_seq",initialValue=100,allocationSize=10)
 @GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
 private Integer tid;
 public Teachers() {
	super();
}
public Teachers( String tName, String tAddress, Long phoneNumber) {
	super();
	
	this.tName = tName;
	this.tAddress = tAddress;
	this.phoneNumber = phoneNumber;
}
@Override
public String toString() {
	return "Teachers [tid=" + tid + ", tName=" + tName + ", tAddress=" + tAddress + ", phoneNumber=" + phoneNumber
			+ "]";
}
public Integer getTid() {
	return tid;
}
public void setTid(Integer tid) {
	this.tid = tid;
}
public String gettName() {
	return tName;
}
public void settName(String tName) {
	this.tName = tName;
}
public String gettAddress() {
	return tAddress;
}
public void settAddress(String tAddress) {
	this.tAddress = tAddress;
}
public Long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public School getSchoolInfo() {
	return schoolInfo;
}
public void setSchoolInfo(School schoolInfo) {
	this.schoolInfo = schoolInfo;
}
@Column(name="teacher_name",length=20)
 private String tName;
 @Column(name="teacher_address",length=20)
 private String tAddress;
 @Column(name="phone_number")
 private Long phoneNumber;
 @ManyToOne(targetEntity=School.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
 @JoinColumn(name="school_id",referencedColumnName="school_code")
 private School schoolInfo;
 
}
