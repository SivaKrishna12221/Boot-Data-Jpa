package com.nt.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nt.repository.IDoctorRepository;

@Component("service")

public class ServiceDoctorClass implements ServiceDoctorInterface {

	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public int appraiseDoctorsIncomeBySpecilization(String speci, double hikeper) {
		int count = doctorRepo.hikeDoctorsIncomeBySpecialization(speci, hikeper);
		return count;
	}

	@Override
	@Modifying
	@Transactional
	public int fireDoctorsByIncomeRange(double range1, double range2) {
		int count = doctorRepo.deleteDoctorsByIncomeRange(range1, range2);
		return count;
	}

	@Override
	public int updateDoctorsIncomeByIds(Integer id1, Integer id2, double income) {
		int count = doctorRepo.updateDoctorsIncomeByIds(id1, id2, income);
		return count;
	}

	@Override
	public String addingNewDoctorData(String name, String specialization, double income) {
		int count = doctorRepo.insertANewDoctorRecord(name, specialization, income);
		return count == 0 ? "not registered" : "one record inserted successfully";
	}

	@Override
	public String displaySystemDate() {

		return doctorRepo.showSytemDate();
	}

	@Override
	public int createTableWithQueryMethod() {

		int count = doctorRepo.createNewTable();
		return count;
	}
}
