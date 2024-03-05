
package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.School;

public interface CustomSchoolRepository extends JpaRepository<School,Integer>{

}
