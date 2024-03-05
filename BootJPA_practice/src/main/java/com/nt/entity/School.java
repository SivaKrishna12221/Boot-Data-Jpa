package com.nt.entity;

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
import jakarta.persistence.Table;

@Entity
@Table(name="jpa_school_info")
public class School implements Serializable
{
  @Id
  @GeneratedValue(generator="se1",strategy=GenerationType.SEQUENCE)
  @Column(name="school_code")
  private Integer schoolCode;
  @Column(name="school_name",length=20)
  private String schoolName;
  @Column(name="head_master",length=20)
  private String headMaster;
  @Column(name="address",length=30)
  private String address;
  @OneToMany(targetEntity=Teachers.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
  @JoinColumn(name="school_id",referencedColumnName="school_code")
  private Set<Teachers> teachers;
public Integer getSchoolCode() {
	return schoolCode;
}
public void setSchoolCode(Integer schoolCode) {
	this.schoolCode = schoolCode;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public String getHeadMaster() {
	return headMaster;
}
public void setHeadMaster(String headMaster) {
	this.headMaster = headMaster;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Set<Teachers> getTeachers() {
	return teachers;
}
public void setTeachers(Set<Teachers> teachers) {
	this.teachers = teachers;
}
@Override
public String toString() {
	return "School [schoolCode=" + schoolCode + ", schoolName=" + schoolName + ", headMaster=" + headMaster
			+ ", address=" + address + "]";
}
public School( String schoolName, String headMaster, String address) {
	super();
	this.schoolName = schoolName;
	this.headMaster = headMaster;
	this.address = address;
}
  
}
