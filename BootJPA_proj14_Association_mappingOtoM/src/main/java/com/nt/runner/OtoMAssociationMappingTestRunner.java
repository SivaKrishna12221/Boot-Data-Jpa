package com.nt.runner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entities.Customer;
import com.nt.entities.PhoneNumbers;
import com.nt.service.IOtoMAssociationMgmtService;

@Component
public class OtoMAssociationMappingTestRunner implements CommandLineRunner
{
	@Autowired
  private IOtoMAssociationMgmtService service;
	@Override
	public void run(String... args) throws Exception {
	
		/* Customer cust=new Customer("chandu","kpm");
		 PhoneNumbers phn1=new PhoneNumbers(7893482042l,"vi");
		 PhoneNumbers phn2=new PhoneNumbers(7434204430l,"idea");
		 phn1.setPerson(cust);
		 phn2.setPerson(cust);
		 Set<PhoneNumbers> phoneNums= new HashSet();
		 phoneNums.add(phn1);
		 phoneNums.add(phn2);
		 cust.setPhoneNumbers(phoneNums);
		 
			String result=service.saveDataUsingCustomer(List.of(cust));
				 System.out.println(result);
				System.out.println("customer and his associated phone numbers are added to the database in two different tables (parent to child)");
				 
			 String results=service.saveDataUsingPhoneNumbers(List.of(phn1,phn2));
			 System.out.println(results);
			 System.out.println("customer and his associated phone numbers are added to the database in two different tables (child to parent)");
				
		//it is also working
		PhoneNumbers ph1=new PhoneNumbers(9034434454l,"vodafone");
		PhoneNumbers ph2=new PhoneNumbers(9345424303l,"airtel");
		PhoneNumbers ph3=new PhoneNumbers(8345764334l,"vi");
		
		Customer cust1=new Customer("manju","kp");
		Customer cust2=new Customer("siva reddy","bihar");
		ph1.setPerson(cust1);
		ph2.setPerson(cust2);
		ph3.setPerson(cust1);
		Set<PhoneNumbers> numDetails=new HashSet();
		numDetails.add(ph3);
		numDetails.add(ph2);
		Set<PhoneNumbers> numDetails2=new HashSet();
		cust1.setPhoneNumbers(numDetails);
		cust2.setPhoneNumbers(numDetails2);
		String result2=service.saveDataUsingPhoneNumbers(List.of(ph1,ph2,ph3));
		System.out.println(result);
		*/		
		service.loadDataUsingParentCustomer();
		service.loadDataUsingChildPhoneNumbers();
	}
}
