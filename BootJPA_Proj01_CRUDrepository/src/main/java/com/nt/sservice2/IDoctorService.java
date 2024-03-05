package com.nt.sservice2;

import com.nt.entity.Doctor;

public interface IDoctorService
{
  public String registerGroupOfDoctors(Iterable<Doctor> docs);
  public String checkTheDoctorById(Integer id);
  public String countNumberOfDoctors();
}
