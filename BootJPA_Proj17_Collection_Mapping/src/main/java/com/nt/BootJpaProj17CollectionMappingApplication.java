package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootJpaProj17CollectionMappingApplication {

	public static void main(String[] args) {
	ApplicationContext ctxt=	SpringApplication.run(BootJpaProj17CollectionMappingApplication.class, args);
	//TrainDetailsServiceMgmt bean = ctxt.getBean("train-service",TrainDetailsServiceMgmt.class);
	//bean.registerTrainDetails();
      //bean.collectListOfTriansByStations();
	}

}
