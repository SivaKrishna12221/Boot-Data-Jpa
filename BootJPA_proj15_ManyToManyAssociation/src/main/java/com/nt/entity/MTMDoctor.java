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
@Table(name="jpa_mtm_doctor1")
public class MTMDoctor 
{
  @Id
  @SequenceGenerator(name="mtm_seq",sequenceName="doctorId_seq",initialValue=100,allocationSize=1)
  @GeneratedValue(generator="mtm_seq",strategy=GenerationType.SEQUENCE)
  @Column(name="did")
  private Integer doctorId;
  @Column(name="doctor_name",length=30)
  private String doctorName;
  @Column(name="specialization",length=30)
  private String specialization;
  @ManyToMany(targetEntity=MTMPatient.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinTable(name="jpa_mtm_doctor_patient",joinColumns=@JoinColumn(name="doctor_id",referencedColumnName="did"),
  inverseJoinColumns=@JoinColumn(name="patient_id",referencedColumnName="pid"))
 // @Column(name="patient_info")
  private List<MTMPatient> patientInfo;
  @Override
public String toString() {
	return "MTMDoctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specialization=" + specialization
			+ "]";
}

public MTMDoctor() {
	super();
}

public MTMDoctor(String doctorName, String specialization) {
	super();
	this.doctorName = doctorName;
	this.specialization = specialization;
}

public Integer getDoctorId() {
	return doctorId;
}

public void setDoctorId(Integer doctorId) {
	this.doctorId = doctorId;
}

public String getDoctorName() {
	return doctorName;
}

public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}

public String getSpecialization() {
	return specialization;
}

public void setSpecialization(String specialization) {
	this.specialization = specialization;
}

public List<MTMPatient> getPatientInfo() {
	return patientInfo;
}

public void setPatientInfo(List<MTMPatient> patientInfo) {
	this.patientInfo = patientInfo;
}

}
