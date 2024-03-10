package com.nt.service;

import com.nt.entity.CallerTune;

public interface IServiceCallerTune
{
 public String  setCallerTune(CallerTune tune);
 public String updateCallerTune(Integer id,String tuneName,String movieName);
 public CallerTune showCallerTuneDetailsById(Integer Id);
}
