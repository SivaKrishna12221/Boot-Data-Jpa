package com.nt.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.nt.repo.offers", entityManagerFactoryRef = "mySqlEMF", transactionManagerRef = "mySqlPTM")
public class MySqlDbConfig {
	@Bean("mySqlDs")
	@ConfigurationProperties(prefix = "mysql.datasource")
	public DataSource createMySqlDs() {
		System.out.println("MySqlDbConfig.createMySqlDs()");
		return DataSourceBuilder.create().build();
	}

	@Bean("mySqlEMF")
	public LocalContainerEntityManagerFactoryBean createMySqlEMF(EntityManagerFactoryBuilder builder) {
		System.out.println("MySqlDbConfig.createMySqlEMF()");
		Map<String, String> hbProp = new HashMap();
		hbProp.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		hbProp.put("hibernate.hbm2ddl.auto", "update");
		return builder.dataSource(createMySqlDs()).packages("com.nt.model.offers").properties(hbProp).build();
	}

	@Bean("mySqlPTM")
	public PlatformTransactionManager crateMySqlPTM(EntityManagerFactory factory) {
		System.out.println("MySqlDbConfig.crateMySqlPTM()");
		return new JpaTransactionManager(factory);
	}
}
