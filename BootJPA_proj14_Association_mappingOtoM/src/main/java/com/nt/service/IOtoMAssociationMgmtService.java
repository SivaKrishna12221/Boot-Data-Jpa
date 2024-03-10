package com.nt.service;

import com.nt.entities.Customer;
import com.nt.entities.PhoneNumbers;

public interface IOtoMAssociationMgmtService 
{
  public String saveDataUsingCustomer(Iterable<Customer> customers);
  public String saveDataUsingPhoneNumbers(Iterable<PhoneNumbers> phNumbers);
  public void loadDataUsingParentCustomer();
  public void loadDataUsingChildPhoneNumbers();
}
