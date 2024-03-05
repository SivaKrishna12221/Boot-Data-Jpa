package com.nt.service2;

public interface IDoctorService 
{
  public String registerNewDoctor(Integer docid,String name,String specialization,Double income);
  public String findDate();
}
