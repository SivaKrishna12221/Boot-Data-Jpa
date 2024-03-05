package com.nt.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;
public interface CustomDoctorRepository extends JpaRepository<Doctor,Integer>
{
  @Query("update Doctor set income=income+(income*:hikepercentage/100.0) where income<:specifiedIncome")
  @Modifying
  @Transactional //if the is written in service no need to take transactional
  public Iterable<Doctor> updateDoctorIncome(@Param("specifiedIncome")Double specifiedIncome,@Param("hikepercentage")Double hikepercentage);
  @Query(value="insert into jpa_doctor_info2 (doctorid,doctorname,specialization,income) values(:id,:name,:specialization,:income)",nativeQuery=true)
  @Modifying
  @Transactional
  public int registerDoctor(@Param("id")Integer id,@Param("name")String name,@Param("specialization")String specialization,@Param("income")Double income);
  @Query(value="select sysdate from dual",nativeQuery=true)
  public String findDate();
}
