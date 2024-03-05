package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Libraury;

public interface CustomTimeRepository extends JpaRepository<Libraury,Integer>
{

}
