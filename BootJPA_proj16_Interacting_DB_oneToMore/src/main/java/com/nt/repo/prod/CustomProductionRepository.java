package com.nt.repo.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.prod.Production;

public interface CustomProductionRepository extends JpaRepository<Production, Integer> {

}
