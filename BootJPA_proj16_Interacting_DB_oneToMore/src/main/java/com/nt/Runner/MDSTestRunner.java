package com.nt.Runner;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Production;
import com.nt.model.promotion.Promotion;
import com.nt.repo.prod.CustomProductionRepository;
import com.nt.repo.promotion.CustomPromotionRepository;

@Component
public class MDSTestRunner implements CommandLineRunner {
	@Autowired
	private CustomProductionRepository prodRepo;
	@Autowired
	private CustomPromotionRepository promRepo;

	@Override
	public void run(String... args) throws Exception {
		prodRepo.saveAllAndFlush(Arrays.asList(new Production("chair", 350d, 3), new Production("fan", 2000d, 2)));

		System.out.println("products are saved successfully");

		promRepo.saveAllAndFlush(
				Arrays.asList(new Promotion("But_two_get_one", "code1", 20d, LocalDateTime.of(2023, 8, 21, 10, 10, 10)),
						new Promotion("buy_one_get_one", "code2", 25d, LocalDateTime.of(2023, 10, 21, 11, 10, 10))));
		System.out.println("offers are saved successfully");
	}

}
