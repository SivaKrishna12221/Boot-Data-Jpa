package com.nt.serviceAssociation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.School;
import com.nt.entity.Teachers;
import com.nt.repository.CustomSchoolRepository;
import com.nt.repository.CustomTeachersRepository;

@Service("oneToManyService")
public class OneToManyServiceImpl implements IOntToManyService
{
	@Autowired
	private CustomSchoolRepository schoolRepo;
	@Autowired
	private CustomTeachersRepository teacherRepo;
 @Override
public void registerSchoolAndTeacherData() {
	
	School sc1=new School("ZPHighSchool","Subbarayudu","kadapa");
	School sc2=new School("surya high school","SubbaReddy","kamalapuram");
	Teachers th1=new Teachers("kesavaReddy","kadapa",9999912345l);
	Teachers th2=new Teachers("ramanjineyulu","kamalapuram",9999912341l);
	Teachers th3=new Teachers("sreenu","appaipalli",9999912342l);
	th1.setSchoolInfo(sc1);
	th2.setSchoolInfo(sc1);
	th3.setSchoolInfo(sc2);
	Set<Teachers> set1=new HashSet();
	set1.add(th1);
	set1.add(th2);
	sc1.setTeachers(set1);
	Set<Teachers> set2=new HashSet();
	set2.add(th3);
	sc2.setTeachers(set2);
	schoolRepo.saveAllAndFlush(List.of(sc1,sc2));
	System.out.println("tables created successfully with relation ");
}
}
