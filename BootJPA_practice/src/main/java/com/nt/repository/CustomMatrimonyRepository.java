package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Matrimony;

public interface CustomMatrimonyRepository extends JpaRepository<Matrimony,Integer>
{

}
