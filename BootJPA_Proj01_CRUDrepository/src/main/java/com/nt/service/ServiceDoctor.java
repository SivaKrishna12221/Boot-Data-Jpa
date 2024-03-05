package com.nt.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.daoInterface.IDoctorRepo;
import com.nt.entity.Doctor;
import com.nt.ssdao.CustomDoctorRepository;

@Service("service")
public class ServiceDoctor implements ServiceInterface {
	@Autowired
	private IDoctorRepo doctorRepo;
	 
	@Autowired
	 private CustomDoctorRepository docRepo;
	// save method
	public String registerDoctor(Doctor doctor) {

		Doctor d1 = doctorRepo.save(doctor);
		return "Doctor obj is saved with id :" + d1.getDocId();
	}

	// save All method
	public String registerGroupOfDoctors(Iterable<Doctor> doctors)// Iterable used to pull the object from one by one
	{

		/*if(doctors!=null)  
		{
		Iterable<Doctor> savedDoctors=doctorRepo.saveAll(doctors);
		int size1=((Collection)savedDoctors).size();
		List<Integer> list=new ArrayList<Integer>();//it is used to save docId in the ArrayList taken from the iterable interface
		savedDoctors.forEach(d->{
			list.add(d.getDocId());
		});
		return size1+" doctors are registered with Ids: "+list.toString();
		
		}
		else
		{
		throw new IllegalArgumentException("Invalid doctors info");
		}*/
		if (doctors != null) {
			Iterable<Doctor> savedDoctors = doctorRepo.saveAll(doctors);
			int size = ((Collection) savedDoctors).size();
			List<Doctor> list = (List<Doctor>) ((Collection) savedDoctors).stream().collect(Collectors.toList());
			for (Doctor singleDoc : list) {
				System.out.println(singleDoc.getDocId() + "," + singleDoc.getName() + "," + singleDoc.getIncome() + ","
						+ singleDoc.getSpecialization());
			}
			System.out.println();

			Map<Integer, String> idName = null;
			for (Doctor o : list) {

				idName = new HashMap<Integer, String>();
				for (int i = 0; i < list.size() - 1; i++) {
					idName.put(o.getDocId(), o.getName());
				}
			}
			return size + " no.of doctors are saved with ids and name:" + idName;
		} else {
			throw new IllegalArgumentException("invalid doctors info");
		}
	}

	// count method
	public Long fetchDoctorsCount() {
		Long countrecords = doctorRepo.count();
		return countrecords;
	}

	// exits by ID
	public boolean checkingAvailabilityOfDoctor(int id) {
		return doctorRepo.existsById(id);
	}

	// find all
	@Override
	public Iterable<Doctor> showAllDoctors() {
		return doctorRepo.findAll();
	}

	// findAllByIds
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids) {
		Iterable<Doctor> iter = doctorRepo.findAllById(ids);
		return iter;
	}

	// find By Id
	public Doctor showSingleDoctor(Integer id) {
		/* Doctor doc=new Doctor();
		 doc.setSpecialization("cardiaologist");
		 Doctor doc2=doctorRepo.findById(id).orElse(doc);
		 return doc2;
		 */
		/* Doctor doc=doctorRepo.findById(id).orElseThrow(()->new IllegalArgumentException("invalid id "));
		  return doc;
		  */
		Optional<Doctor> opt = doctorRepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new IllegalArgumentException("Invalid id");
		}
	}
   //@Override
	public String udpateIncomeById(int id, float hikePercentage) {
		Optional<Doctor> opt = doctorRepo.findById(id);

		if (opt.isPresent()) {
			Doctor doctor = opt.get();
			double newIncome = doctor.getIncome() + doctor.getIncome() * hikePercentage / 100;
			doctor.setIncome(newIncome);
			return doctorRepo.save(doctor).getDocId() + "id updated with" + newIncome;
		} else {
			throw new IllegalArgumentException("invalid id");
		}
	}

	// regiter or update by using find and save method
	@Override
	public String updateOrRegister(Doctor doctor) {

		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocId());
		if (opt.isPresent()) {
			doctorRepo.save(doctor);
			return doctor.getDocId() + " id doctor details are found and updated";
		} else {
			return "doctor is registered with id value" + doctorRepo.save(doctor).getDocId();
		}

	}

	// delete concepts
	// delete entity by using id
	public String deleteEntityById(Integer id) {
		Optional<Doctor> opt = doctorRepo.findById(id);
		if (opt.isPresent()) {
			doctorRepo.deleteById(id);
			return id + "value is deleted successfully";
		} else {
			return "id is not present in the data base";
		}
	}

	// delete entity by using entity object
	@Override
	public String deleteDoctor(Doctor doctor) {
		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocId());
		if (opt.isEmpty()) {
			throw new IllegalArgumentException(opt.get().getDocId() + "id  is not found");
		} else {
			doctorRepo.delete(opt.get());
			return opt.get().getDocId() + " found and deleted successfully";
		}
	}

	public String removeAllDoctors() {
		Long count = doctorRepo.count();
		if (count > 0) {
			doctorRepo.deleteAll();
			return count + "no.of doctors are deleted Successfully";
		}
		return "doctors are not found";

	}

	public String removeDoctorsByIds(List<Integer> ids) {
		List<Doctor> doclists = (List<Doctor>) doctorRepo.findAllById(ids);
		if (doclists.size() == ids.size()) {
			doctorRepo.deleteAllById(ids);
			return ids.size() + ":no.of records deleted successfully";

		}
		return "some of given id values are not found in the database";
	}

	// pagingAndSortingRepository
	public Iterable<Doctor> showDoctorsBySorting(boolean asc, String... props) {
		Sort sort1 = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		Iterable<Doctor> doctors = doctorRepo.findAll(sort1);
		return doctors;
	}

	// paging
	public Page<Doctor> showDoctorsInfoByPageNo(int pageno, int pagesize, boolean asc, String props) 
	{
		Sort sort1 = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		Pageable pageable =PageRequest.of(pageno, pagesize, sort1);
		Page<Doctor> page = doctorRepo.findAll(pageable);
		return page;
	}

	// showDataThroughPagination
	public void showDataThroughPagination(int pagesize) {
		// decide the no.of pages
		long count = doctorRepo.count();// get the no.of records
		long countpages = count / pagesize;
		System.out.println("count records:" + count);
		System.out.println("count pages:" + countpages);
		if (count % countpages != 0) {
			count++;
		}
		for(int i=0;i<countpages;++i)
		{
			Pageable pageable=PageRequest.of(i,pagesize);
			Page<Doctor> page=doctorRepo.findAll(pageable);
			System.out.println("page.getNumber"+(page.getNumber()+1)+"page records of :"+page.getTotalPages());
			page.getContent().forEach(data->System.out.println(data.getName()));
			System.out.println("_____________");
		}

		//
	}

	public String deleteDoctorsByIdsInBatch(List<Integer> ids) {
		// load the entities
		List<Doctor> list1 = doctorRepo.findAllById(ids);
		// delete all ids in batch with a single query
		doctorRepo.deleteAllByIdInBatch(ids);// this return type is void
		return list1.size() + "no.of  records deleted successfully";
	}
	// findAllById in crud repository

	public Iterable<Doctor> showAllDoctorsByCrud(Iterable<Integer> ids) {
		Iterable<Doctor> iter = doctorRepo.findAllById(ids);
		return iter;
	}

	public List<Doctor> showAllDoctorsByJpa(List<Integer> ids) {
		List<Doctor> list = doctorRepo.findAllById(ids);
		return list;
	}

	// getReferenceById
	public Doctor getDoctorById(Integer id) {
		Doctor doc = doctorRepo.getReferenceById(id);
		return doc;
	}
    //show doctor on Example Data
	public List<Doctor> showDoctorByExampleData(Doctor exDoctor,boolean asc,String...props)
	{
		Sort sort1=Sort.by(asc?Direction.ASC:Direction.DESC,props);
		Example ex=Example.of(exDoctor);
		List<Doctor> list=doctorRepo.findAll(ex,sort1);
		return list;
		
	}
	public String groupOfDoctorsRegistration(List<Doctor> docs)
	{
		List<Doctor> list=doctorRepo.saveAllAndFlush(docs);
		return list.size()+"objects are save and Flush successfully";
	}
	
    @Override
    public List<Doctor> getListOfDocs(String... args) {
    	// TODO Auto-generated method stub
         List<Doctor> docs = docRepo.fetchListOfDoctorsUsingStringArgs("Sudharshan","siri","kalayani");
         return docs;
    }
    
}
