package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
@Service("service")
public class EmployeeServiceClass implements IEmpService
{
	@Autowired
  private EntityManager manager;
	
@Override
public List<Employee> fetchEmployeeDetailsInRange(double start, double end) {
	StoredProcedureQuery query=manager.createStoredProcedureQuery("GET_LIST_EMPLOYESS_IN_RANGE",Employee.class);
	query.registerStoredProcedureParameter(1,double.class,ParameterMode.IN);
	query.registerStoredProcedureParameter(2,double.class,ParameterMode.IN);
	query.setParameter(1,start);
	query.setParameter(2,end);
	List<Employee> list=query.getResultList();
	
	return list;
}
}
