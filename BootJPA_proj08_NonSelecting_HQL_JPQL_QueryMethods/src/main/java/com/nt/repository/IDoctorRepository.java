package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Doctor;

@Component
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	@Query("update Doctor set income=income-income*:hikepercentage/100 where specialization=:specia")
	@Modifying
	@Transactional
	public int hikeDoctorsIncomeBySpecialization(String specia, double hikepercentage);

	@Query("delete from Doctor where income>:start and income<:end")
	public int deleteDoctorsByIncomeRange(double start, double end);

	@Query("update Doctor set income=:income1  where docId in(:id1,:id2)")
	@Modifying
	@Transactional
	public int updateDoctorsIncomeByIds(Integer id1, Integer id2, double income1);
    @Query(value="insert into jpa_doctor_info2 (doctorid,doctorname,specialization,income)values (jpa_seq.NEXTVAL,:name,:specialization,:income)",nativeQuery=true)
    @Modifying
    @Transactional
    public int  insertANewDoctorRecord(String name,String specialization,double income);
    @Query(value="select sysdate from dual",nativeQuery=true)
    public String showSytemDate();
    @Query(value="create table jpa_table3(id number(5),name varchar2(10))",nativeQuery=true)
    @Modifying
    @Transactional
    public int createNewTable();
}
