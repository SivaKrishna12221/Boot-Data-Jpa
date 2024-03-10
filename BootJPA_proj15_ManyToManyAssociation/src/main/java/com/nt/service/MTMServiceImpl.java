package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MTMDoctor;
import com.nt.entity.MTMPatient;
import com.nt.repository.CustomMTMDoctorRepository;
import com.nt.repository.CustomMTMPatientRepository;

@Service("mtmService")
public class MTMServiceImpl implements IMTMService
{
	@Autowired
	private CustomMTMDoctorRepository mtmDocRepo;
	@Autowired
	private CustomMTMPatientRepository mtmpatRepo;
 @Override
public void saveDoctorData() {
	 
	 MTMDoctor doc1=new MTMDoctor("gopal","dermotologist");
	 MTMDoctor doc2=new MTMDoctor("mohanRao","neurologist");
	 MTMPatient pat1=new MTMPatient(23,"ramam","skin");
	 MTMPatient pat2=new MTMPatient(24,"vignesh","spinal cord");
	 MTMPatient pat3=new MTMPatient(25,"rajesh","hair");
	 MTMPatient pat4=new MTMPatient(21,"sathish","neurological disorder");
	List<MTMPatient> docInfo1= new ArrayList();
	docInfo1.add(pat1);
	docInfo1.add(pat3);
	doc1.setPatientInfo(docInfo1);
	List<MTMPatient> docInfo2=new ArrayList();
	docInfo2.add(pat4);
	docInfo2.add(pat2);
	doc2.setPatientInfo(docInfo2);
	List<MTMDoctor> docInfo3=new ArrayList();
	docInfo3.add(doc2);
	List<MTMDoctor> docInfo4=new ArrayList();
	docInfo3.add(doc1);
	
	pat1.setDoctorInfo((docInfo3));
	pat2.setDoctorInfo((docInfo3));
	pat3.setDoctorInfo((docInfo4));
	pat4.setDoctorInfo((docInfo4));
	mtmDocRepo.saveAllAndFlush(List.of(doc1,doc2));
}
 @Override
public void saveDataUsinPatient() {
	
	 MTMDoctor doc1=new MTMDoctor("ganesh","cardiologist");
	 
	 MTMPatient pat1=new MTMPatient(45,"narasimha","heart");
	 MTMPatient pat2=new MTMPatient(34,"vikram","blood ");
	 
	 MTMDoctor doc2=new MTMDoctor("sunil","opthamalogy");
	 
	 MTMPatient pat3=new MTMPatient(33,"varun","lasic eye surgery");
	 MTMPatient pat4=new MTMPatient(28,"arya","eye problem");
	 
	 MTMDoctor doc3=new MTMDoctor("ramu","Gastroenterologists");
	 MTMPatient pat5=new MTMPatient(30,"sharath","cancer");
	 
	 
	 //we can take collection for docs and also collection for patient
	 //we can set the data in any way .through doctors or through patients
	 // i will the data through patient
	 List<MTMDoctor> doctor1=new ArrayList();
	 doctor1.add(doc1);
	 doctor1.add(doc3);
	 pat1.setDoctorInfo(doctor1);
	 pat2.setDoctorInfo(doctor1);
	 List<MTMDoctor> doctor2=new ArrayList();
	 doctor2.add(doc2);
	 doctor2.add(doc1);
	 pat3.setDoctorInfo(doctor2);
	 pat4.setDoctorInfo(doctor2);
	 List<MTMDoctor> doctor3=new ArrayList();
	 doctor2.add(doc3);
	 pat5.setDoctorInfo(doctor3);
	 mtmpatRepo.saveAllAndFlush(List.of(pat1,pat2,pat3,pat4,pat5));
 }
 @Override
public void loadDataUsingDoctor() {
	
   Iterable<MTMDoctor> docsAndPatients=  mtmDocRepo.findAll();
   docsAndPatients.forEach(docs->{System.out.println("parent:"+docs);
	   List<MTMPatient> patientInfo=docs.getPatientInfo();
	   patientInfo.forEach(System.out::println);
   });
}
 @Override
public void loadDataUsingPatient() {
	Iterable<MTMPatient> patientAndDocs=mtmpatRepo.findAll();
	
	patientAndDocs.forEach(pat->{System.out.println("patient:"+pat);
		List<MTMDoctor> doc=pat.getDoctorInfo();
		doc.forEach(doctors->System.out.println("doctors:"+doctors));
	});
	
}
}
