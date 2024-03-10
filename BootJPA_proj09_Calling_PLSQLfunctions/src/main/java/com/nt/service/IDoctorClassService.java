package com.nt.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.ResultSetOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.repo.IDoctorRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Component("service")
public class IDoctorClassService implements IDoctorInterService {
	@Autowired
	private EntityManager manager;

	@Autowired
	private IDoctorRepo docRepo;

	@Override
	public List<Doctor> getDetailsByRange(Double start, double end) {
		// create stored procedure object pointing to plsql procedure program
		System.out.println(manager.toString());
		StoredProcedureQuery query = manager.createStoredProcedureQuery("GET_DOCTOR_DETAILS_BY_RANGE", Doctor.class);
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Class.class, ParameterMode.REF_CURSOR);
		query.setParameter(1, start);
		query.setParameter(2, end);
		List<Doctor> resultList = query.getResultList();
		return resultList;
		/* List<Doctor> docs = docRepo.getDocs(80000, 100000,Doctor.class);
		return  docs;*/
	}

	@Override
	public List<String> getListOfDoctorsName(String spec) {

		StoredProcedureQuery spq = manager.createStoredProcedureQuery("GET_LIST_DOCTORS_BY_NAME", String.class);
		spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		spq.registerStoredProcedureParameter(2, String.class, ParameterMode.REF_CURSOR);
		spq.setParameter(1, spec);
		List<String> resultList = spq.getResultList();
		return resultList;
	}

	@Override
	public List<Object[]> getListOfDoctorsByLimit(double income) {

		/*StoredProcedureQuery query = manager.createStoredProcedureQuery("GET_DOCTORS_BY_LIMIT",Object.class);
		query.registerStoredProcedureParameter(1,Double.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,void.class,ParameterMode.REF_CURSOR);
		query.setParameter(1,income);
		List<Object[]> resultList = query.getResultList();
		return resultList;*/ // it is not working
		Session session = manager.unwrap(Session.class);
		ProcedureCall call = session.createStoredProcedureCall("GET_DOCTORS_BY_LIMIT");
		call.registerParameter(1, Double.class, ParameterMode.IN);
		call.registerParameter(2, Object.class, ParameterMode.REF_CURSOR);
		call.setParameter(1, income);
		ResultSetOutput resultSetOutput = (ResultSetOutput) call.getOutputs().getCurrent();

		List<Object[]> docs = resultSetOutput.getResultList();
		/* for (Object[] employee : employees) {
		     Long id = ((Number) employee[0]).longValue(); // Assuming ID is the first column
		     String name = (String) employee[1]; // Assuming Name is the second column
		     System.out.println("Employee ID: " + id + ", Name: " + name);
		 }*/
		return docs;
	}

	@Override
	public List<Object[]> getListOfDoctorsAboveLimt(double income) {

		Session ses = manager.unwrap(Session.class);
		ProcedureCall call = ses.createStoredProcedureCall("GET_LIST_OF_DOCTORS_GREATER_INCOME");
		call.registerParameter(1, Double.class, ParameterMode.IN);
		call.registerParameter(2, Object[].class, ParameterMode.REF_CURSOR);
		call.setParameter(1, income);
		ResultSetOutput rso = (ResultSetOutput) call.getOutputs().getCurrent();
		List<Object[]> resultList = rso.getResultList();
		return resultList;
	}

}
