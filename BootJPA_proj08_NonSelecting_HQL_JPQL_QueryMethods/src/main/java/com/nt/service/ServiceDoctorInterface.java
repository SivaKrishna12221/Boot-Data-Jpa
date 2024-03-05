package com.nt.service;

import java.sql.Date;

public interface ServiceDoctorInterface {
	public int appraiseDoctorsIncomeBySpecilization(String speci, double hikeper);

	public int fireDoctorsByIncomeRange(double range1, double range2);

	public int updateDoctorsIncomeByIds(Integer id1, Integer id2, double income);

	public String addingNewDoctorData(String name, String specialization, double income);

	public String displaySystemDate();

	public int createTableWithQueryMethod();
}
