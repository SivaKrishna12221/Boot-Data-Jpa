package com.nt.serviceTime;

import com.nt.entity.CollerTune;
import com.nt.entity.Libraury;

public interface ILibrauryService 
{
 public Libraury registerStudentDetails(Libraury lib);
 public CollerTune setCollerTune(CollerTune tune);
 
 
 public String getTuneInfo(Integer id);
}
