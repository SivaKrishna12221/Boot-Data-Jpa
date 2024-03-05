package com.nt.serviceTime;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CollerTune;
import com.nt.entity.Libraury;
import com.nt.repository.CustomCollerTuneRepository;
import com.nt.repository.CustomTimeRepository;
@Service("librauryService")
public class LibrauryServiceImpl implements ILibrauryService
{
	@Autowired
	private CustomCollerTuneRepository collerRepo;
	@Autowired
	private CustomTimeRepository libRepo;
  @Override
public Libraury registerStudentDetails(Libraury lib) {
    Libraury libra=libRepo.saveAndFlush(lib);
	return libra;
	
}
 @Override
public CollerTune setCollerTune(CollerTune tune) {
	CollerTune ctune=collerRepo.save(tune);
	return ctune;
} 
 @Override
public String getTuneInfo(Integer id) {
	 Optional<CollerTune>  opt= collerRepo.findById(id);
	 if(opt.isPresent())
	 {
		 CollerTune ct=opt.get();
		 String s1=ct.getTuneName();
		 String s2=ct.getMovieName();
		 return s1+":String TuneName,"+s2+" movieName "+ct.getCountUpdate()+","+ct.getLastlySaved()+","+ct.getLastlyUpdated();
	 }
	return "tune is not present";
}
}
