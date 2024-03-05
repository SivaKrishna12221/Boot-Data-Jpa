package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NonNull;
//@Entity
@Table(name="jpa_libraury")
public class Libraury
{
   public Libraury() {
		super();
	}
public Libraury(String studentName, LocalDateTime dob, LocalDate doj, LocalTime toj) {
		super();
		this.studentName = studentName;
		this.dob = dob;
		this.doj = doj;
		this.toj = toj;
	}
@Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Integer studentId;
   @Column(name="student_name",length=20)
   private String studentName;
   @NonNull
   @Column(name="date_Of_Birth")
	private LocalDateTime dob;
   @NonNull
   @Column(name="date_Of_Join")
	   private LocalDate doj;
   @NonNull
   @Column(name="time_of_join")
	   private LocalTime toj;

public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public Integer getStudentId() {
	return studentId;}
public LocalDateTime getDob() {
	return dob;
}
public void setDob(LocalDateTime dob) {
	this.dob = dob;
}
public LocalDate getDoj() {
	return doj;
}
public void setDoj(LocalDate doj) {
	this.doj = doj;
}
public LocalTime getToj() {
	return toj;
}
public void setToj(LocalTime toj) {
	this.toj = toj;
}
@Override
public String toString() {
	return "Libraury [studentId=" + studentId + ", studentName=" + studentName + ", dob=" + dob + ", doj=" + doj
			+ ", toj=" + toj + "]";
}


}
