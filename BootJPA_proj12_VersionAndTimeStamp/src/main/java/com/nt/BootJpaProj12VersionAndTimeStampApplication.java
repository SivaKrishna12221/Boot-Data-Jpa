package com.nt;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.CustomCollerTuneRepository;

@SpringBootApplication
public class BootJpaProj12VersionAndTimeStampApplication {
    
	
	public static void main(String[] args) {
	/*ApplicationContext ctx*/	SpringApplication.run(BootJpaProj12VersionAndTimeStampApplication.class, args);
	/*CustomCollerTuneRepository repo=ctx.getBean("custRepo",CustomCollerTuneRepository.class);
	Optional opt=repo.findById(12);
	System.out.println(opt.get());*/

}
}
