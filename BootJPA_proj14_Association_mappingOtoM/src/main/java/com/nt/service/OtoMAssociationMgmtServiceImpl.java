package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entities.Customer;
import com.nt.entities.PhoneNumbers;
import com.nt.repository.ICustomerRepository;
import com.nt.repository.IPhoneNumberRepository;
@Service("otomMgmtService")
public class OtoMAssociationMgmtServiceImpl implements IOtoMAssociationMgmtService
{
@Autowired
 private ICustomerRepository custRepo;
 @Autowired
  private IPhoneNumberRepository phoneRepo;
@Override
public String saveDataUsingCustomer(Iterable<Customer> customers) {
	Iterable<Customer> custs=custRepo.saveAll(customers);
	int custSize=((Collection)custs).size();
	List<Integer> list=new ArrayList<Integer>();
	custs.forEach(docids->list.add(docids.getCno()));
	
	return custSize+" customers addedd successfully with ids:"+list.toString();
}
@Override
	public String saveDataUsingPhoneNumbers(Iterable<PhoneNumbers> phNumbers) {
		Iterable<PhoneNumbers> phoneInfo=phoneRepo.saveAll(phNumbers);
		int size=((Collection)phoneInfo).size();
		List<Integer>numbers=new ArrayList<Integer>();
		phoneInfo.forEach(data->numbers.add(data.getRegisterId()));
		return size+" phoneNumbers addedd successfully "+numbers.toString();
	}
@Override
	public void loadDataUsingParentCustomer() {
		List<Customer> list=custRepo.findAll();
		list.forEach(data->
		{
			System.out.println("parents"+data);
		   Set<PhoneNumbers> numbers=data.getPhoneNumbers();
			/*numbers.forEach(child->
			   System.out.println("child"+child));
			*/
		});
	}
@Override
	public void loadDataUsingChildPhoneNumbers() {
		List<PhoneNumbers> numbers=phoneRepo.findAll();
		numbers.forEach(
			phoneInfo->{
			  System.out.println("childNumbers:"+phoneInfo);
					/*Customer cust=  phoneInfo.getPerson();
					System.out.println(cust);*/
			}
			);
		
	}
}
