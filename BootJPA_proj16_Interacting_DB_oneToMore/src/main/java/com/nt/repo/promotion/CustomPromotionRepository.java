package com.nt.repo.promotion;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.promotion.Promotion;

public interface CustomPromotionRepository extends JpaRepository<Promotion,Integer>{

}