package com.nt.runner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.offers.Offers;
import com.nt.model.prod.Products;
import com.nt.repo.offers.CustomOffersRepositoy;
import com.nt.repo.prod.CustomProductsRepository;

@Component
public class DbInteractinTestRunner implements CommandLineRunner
{
	@Autowired
	private CustomProductsRepository productsRepo;
	@Autowired
	private CustomOffersRepositoy offersRepo;
 @Override
public void run(String... args) throws Exception {
   productsRepo.saveAllAndFlush(Arrays.asList(new Products("laptap",69844.d,1),new Products("television",25000d,1)));
   System.out.println("products are added in oracle Database");
   offersRepo.saveAllAndFlush(Arrays.asList(new Offers(101,"buy_one_getOne","code1",23d,LocalDateTime.of(2023,10,21,10,10,10)),new Offers(102,"buy_two_get_25p","code2",25d,LocalDateTime.of(2023,10,10,11,11,11))));
   
	System.out.println("offers are added in mysql data base");
}
}
