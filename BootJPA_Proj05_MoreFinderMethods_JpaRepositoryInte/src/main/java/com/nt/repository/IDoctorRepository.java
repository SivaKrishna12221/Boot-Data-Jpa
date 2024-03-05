package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Doctor;
import com.nt.entity.IResultView;
import com.nt.entity.IResultView2;
import com.nt.entity.Iview;

public interface IDoctorRepository extends JpaRepository<Doctor,Integer>
{
   public Iterable<Doctor> findByIncomeGreaterThanEqualAndIncomeLessThanEqual(double sIncome,double lIncome);
   
   public List<Doctor> findBySpecializationInOrIncomeBetween(Iterable<String> spes,double sIncome,double lIncome);
   
   //by using resutl view interview
   public List<IResultView> findBySpecializationIn(Iterable<String> specs);
   //get the dynamic properties by specifiying the type of properties you want
   public <T extends Iview > Iterable<T> findByIncomeBetween(double sincome,double lincome,Class<T> props);
   
   public <T extends Iview> Iterable<T> findByDocIdBetween(Integer range1,Integer range2,Class<T> type);
  
   public <T extends Iview> List<T> findByDocIdIn(Iterable<Integer> docIds,Class<T> type);
}
