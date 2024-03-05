package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Teachers;

public interface CustomTeachersRepository extends JpaRepository<Teachers,Integer>
{

}
