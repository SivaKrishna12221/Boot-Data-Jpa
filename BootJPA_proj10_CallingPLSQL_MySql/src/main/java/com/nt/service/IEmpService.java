package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmpService 
{
  public List<Employee> fetchEmployeeDetailsInRange(double start,double end);
}
