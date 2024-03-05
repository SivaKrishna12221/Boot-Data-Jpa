package com.nt.servicePlsql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
@Service("doctorServicePlsql")
public class DoctorServiceImplPlSql implements IDoctorServicePlSql
{
	@Autowired
	private EntityManager manager;
	@Override
	public List<Doctor> showDoctorDetailsByRange(Double range1, Double range2) {
		
	  	  StoredProcedureQuery query= manager.createStoredProcedureQuery("jpa_doctor_info_by_range",Doctor.class);
	  	  query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
	  	  query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
	  	  query.registerStoredProcedureParameter(3,Object.class,ParameterMode.REF_CURSOR);
	  	  query.setParameter(1, range1);
	  	  query.setParameter(2,range2);
	  	  List<Doctor> list= query.getResultList();
	  	  return list;
		
	}
	@Override
	public List<String> showDoctorNamesByRange(Double range1, Double range2) {
     StoredProcedureQuery query=	manager.createStoredProcedureQuery("jpa_doctor_info_by_range2",Doctor.class);
	  query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);	
	  query.registerStoredProcedureParameter(2,Double.class,ParameterMode.IN);
	  query.setParameter(1,range1);
	  query.setParameter(2,range2);
	  List<String> list=query.getResultList();
	  return list;
	}
}
