package com.nt.repo.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.prod.Products;

public interface CustomProductsRepository extends JpaRepository <Products,Integer> {

}
