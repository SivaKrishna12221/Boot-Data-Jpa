package com.nt.servicePlsql;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorServicePlSql
{
    public List<Doctor> showDoctorDetailsByRange(Double range1,Double range2);
    public List<String> showDoctorNamesByRange(Double range1,Double range2);
    
}
