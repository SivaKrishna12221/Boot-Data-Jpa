package com.nt.serviceLobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Matrimony;
import com.nt.repository.CustomMatrimonyRepository;
@Service("matrimony")
public class MatrimonyServiceImpl implements IMatrimonyService
{
	@Autowired
	private CustomMatrimonyRepository matriRepo;
@Override
public Matrimony savePersonData(Matrimony matri) {
	Matrimony personInfo= matriRepo.saveAndFlush(matri);
	return personInfo;
}
}
