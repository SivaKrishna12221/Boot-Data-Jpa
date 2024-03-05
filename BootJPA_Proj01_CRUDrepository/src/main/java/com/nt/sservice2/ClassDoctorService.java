package com.nt.sservice2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.ssdao.CustomDoctorRepository;

@Service("classDoctorService")
public class ClassDoctorService implements IDoctorService {
	@Autowired
	private CustomDoctorRepository custRepo;

	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> docs) {
		Iterable<Doctor> doctors = custRepo.saveAll(docs);
		int size = ((Collection) doctors).size();
		List<Integer> ids = new ArrayList<Integer>();
		doctors.forEach(docids -> ids.add(docids.getDocId()));
		return size + " doctors are added with doctor ids:" + ids.toString();
	}

	@Override
	public String checkTheDoctorById(Integer id) {
		Boolean flag = custRepo.existsById(id);
		if (flag == true) {
			return "doctor is present:" + flag.getClass();
		} else {
			return "doctor is not present";
		}

	}

	@Override
	public String countNumberOfDoctors() {
		Long count = custRepo.count();
		return count + " doctors are present";
	}

}
