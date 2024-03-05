package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;

import com.nt.entity.Doctor;
import com.nt.service.ServiceDoctor;

@SpringBootApplication
public class BootJpaProj01CruDrepositoryApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(BootJpaProj01CruDrepositoryApplication.class, args);
		ServiceDoctor service = ctx.getBean("service", ServiceDoctor.class);
		/*try {//save method
			Doctor doc = new Doctor();
			doc.setDocId(100);//first priority is given id
			doc.setName("siva");
			doc.setSpecialization("mpc");
			doc.setIncome(80100);
			String result = service.registerDoctor(doc);
			System.out.println(result);
		} */
		/*try {//save all method
			Doctor doc = new Doctor();
			doc.setName("sneha");
			doc.setSpecialization("bipc");
			doc.setIncome(80100);
			Doctor doc2 = new Doctor();
			doc2.setName("ram");
			doc2.setSpecialization("pharmd");
			doc2.setIncome(600000);
			Doctor doc3 = new Doctor();
			doc3.setName("ravi");
			doc3.setSpecialization("pharmcy");
			doc3.setIncome(630000);
			String result = service.registerGroupOfDoctors(List.of(doc, doc2, doc3));
			System.out.println(result);
		} 
		*/
		//count method purpose
		/*try {
			Long count=service.fetchDoctorsCount();
			System.out.println("No.of doctors present in the hospital:"+count);
		}*/
		/*try {
			Boolean flag=service.checkingAvailabilityOfDoctor(10);
			if(flag==true)
			{
				System.out.println("doctor is present"+flag.getClass());
			}
			else
			{
				System.out.println("that type doctor not present");
			}
		}*/
		/*try {
			Iterable<Doctor> gotAllDoctors=service.showAllDoctors();
			gotAllDoctors.forEach(data->System.out.println(data.getDocId()+","+data.getName()+","+data.getSpecialization()+","+data.getIncome()));	
		}*/
		/*try {
			Iterable<Doctor> gotAllDoctorsByIds=service.showAllDoctorsByIds(List.of(101,102,30,34,23));
			gotAllDoctorsByIds.forEach(docs->System.out.println(docs.getDocId()+","+docs.getName()+","+docs.getIncome()+","+docs.getSpecialization()));
			
			service.showAllDoctorsByIds(List.of(101,102,30,34,23)).forEach(System.out::println);
		}*/
		/*try {
			Doctor doc=service.showSingleDoctor(200);
			//System.out.println(doc.getIncome()+","+doc.getName()+","+doc.getSpecialization()+","+doc.getDocId());
			System.out.println(doc);
		}*/
		/*try//update Income by using findById,save() method.
		{
			System.out.println(service.showSingleDoctor(50).getIncome());
			System.out.println(service.udpateIncomeById(50,10));
			System.out.println(service.showSingleDoctor(50).getIncome());
		}*/
		/*try {
			Doctor doc3 = new Doctor();
			doc3.setDocId(5);
			doc3.setName("siva");
			doc3.setSpecialization("neurology");
			doc3.setIncome(70000);
			System.out.println(service.updateOrRegister(doc3));
		}*/
		
		//delete by Id
		/*try {
			String result=service.deleteEntityById(100);
			System.out.println(result);
		}*/
		//delete entity by using entity object
		/*try {
			Doctor doctor=new Doctor();
			doctor.setDocId(41);doctor.setName("ram");
			System.out.println(service.deleteDoctor(doctor));
		}*/
		//delete all entity
		/*try {
	     System.out.println(service.removeAllDoctors());
		}*/
		//delete all by id  
		/*try {
		System.out.println(service.removeDoctorsByIds(List.of(3,4,5)));
		}*/
		//Paging and sorting repository
		/*try {
			Iterable<Doctor> doctors=service.showDoctorsBySorting(true,"name");
			doctors.forEach(System.out::println);
			System.out.println("-----------for descending order ---------------");
			service.showDoctorsBySorting(false,"name").forEach(System.out::println);
		}*/
		//get the pages 
		/*	try {
				Page<Doctor> page=service.showDoctorsInfoByPageNo(3,5,true,"name");
				//page.forEach(System.out::println);
				System.out.println("page size"+page.getSize());
				System.out.println("pageNumber"+page.getNumber());
				System.out.println("total pages"+page.getTotalPages());
				System.out.println("is it the first page"+page.isFirst());
				System.out.println("is is the last page"+page.isLast());
				if(!page.getContent().isEmpty())
				{
				  List<Doctor>	list=page.getContent();
				  list.forEach(System.out::println);
				}
				else
				{
					System.out.println("data is not present");
				}
			}
		/*try {
	         service.showDataThroughPagination(3);
		}*/
		
		//JpaRepository interface
		/*try {
		  System.out.println(service.deleteDoctorsByIdsInBatch(List.of(101,102,103,104)));
		 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 try {
			  System.out.println(service.deleteDoctorsByIdsInBatch(List.of(105,106,null)));//throws null pointer exception
				
		}
		catch(Exception e)
		 {
			 e.printStackTrace();
		 }*/
		/* try {
			 System.out.println(service.deleteDoctorsByIdsInBatch(Arrays.asList(107,108,null)));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }*/
		//findAllByIdIn using crud repository
		/*try {
		 Iterable<Doctor> docs= service.showAllDoctorsByCrud(List.of(110,102,103,104));
		docs.forEach(System.out::println);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		try {
			List<Doctor> docs=service.showAllDoctorsByJpa(List.of(110,102,103,104));
			docs.forEach(System.out::println);
		}*/
		/*try {
			Doctor doc=new Doctor();
			doc.setSpecialization("bipc");//this values act in the where clause statement.
			doc.setIncome(80100);//if we specialization data into the table we get all the same specialization data
			doc.setName("sneha");//if we pass any value we can get the all matching records
	
			
			List<Doctor> list=service.showDoctorByExampleData(doc,true,"income");//here property name should be same according to the doctor obj,not in the doctor object
			list.forEach(System.out::println);
		}*/
		/*try {
			Doctor doc1 =new Doctor("sainath","cardiology",130000D);
			Doctor doc2=new Doctor("vivek","dentist",null);
			System.out.println(service.groupOfDoctorsRegistration(List.of(doc1,doc2)));
		}*/
	/*	catch(Exception e)
		{
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) ctx).close();*/
		
	}

}
