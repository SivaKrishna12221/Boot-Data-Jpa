package com.nt.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer id;
	public String empname;
	public String address;
	public String email;
	public Integer manager;
}
