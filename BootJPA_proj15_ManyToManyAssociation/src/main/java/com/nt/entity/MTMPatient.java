package com.nt.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="jpa_mtm_patient1")
public class MTMPatient 
{
@Override
public String toString() {
	return "MTMPatient [patientId=" + patientId + ", patientAge=" + patientAge + ", patientName=" + patientName
			+ ", problem=" + problem + "]";
}
@Id
@Column(name="pid")
@SequenceGenerator(name="mtmPatient",sequenceName="patient_id",initialValue=1000,allocationSize=1)
@GeneratedValue(generator="mtmPatient",strategy=GenerationType.SEQUENCE)
 private Integer patientId;
@Column(name="patient_age")
 private Integer patientAge;
@Column(name="patient_Name",length=30)
 private String patientName;
@Column(name="problem",length=30)
 private String problem;
 @ManyToMany(targetEntity=MTMDoctor.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
 @JoinTable(name="jpa_mtm_doctor_patient",joinColumns=@JoinColumn(name="patient_id",referencedColumnName="pid"),
 inverseJoinColumns=@JoinColumn(name="doctor_id",referencedColumnName="did"))
	/*@Column(name="doctor_info")
	*/ 
 private List<MTMDoctor> doctorInfo;
 
 public MTMPatient() {
	super();
}
public MTMPatient(Integer patientAge, String patientName, String problem) {
	super();
	this.patientAge = patientAge;
	this.patientName = patientName;
	this.problem = problem;
}
public Integer getPatientId() {
	return patientId;
}
public void setPatientId(Integer patientId) {
	this.patientId = patientId;
}
public Integer getPatientAge() {
	return patientAge;
}
public void setPatientAge(Integer patientAge) {
	this.patientAge = patientAge;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getProblem() {
	return problem;
}
public void setProblem(String problem) {
	this.problem = problem;
}
public List<MTMDoctor> getDoctorInfo() {
	return doctorInfo;
}
public void setDoctorInfo(List<MTMDoctor> doctorInfo) {
	this.doctorInfo = doctorInfo;
}

 
 
}
