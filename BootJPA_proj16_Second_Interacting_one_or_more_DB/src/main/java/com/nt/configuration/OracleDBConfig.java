package com.nt.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.nt.repo.prod",entityManagerFactoryRef="oracleEMF",transactionManagerRef="oraclePTM")
public class OracleDBConfig 
{
  @ConfigurationProperties(prefix="oracle.datasource")
  @Bean("oracleDB")
  @Primary
  public DataSource createOracleDb()
  {
	  System.out.println("OracleDBConfig.createOracleDb()");
	  return DataSourceBuilder.create().build();
  }
  @Bean("oracleEMF")
  public LocalContainerEntityManagerFactoryBean createEMF(EntityManagerFactoryBuilder builder)
  {
	 System.out.println("OracleDBConfig.createEMF()");
	 
	Map<String,String> hbMap=   new HashMap();
	hbMap.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
	hbMap.put("hibernate.hbm2ddl.auto","update");
	//create and return local container object
	return builder.dataSource(createOracleDb()).packages("com.nt.model.prod").properties(hbMap).build();
  }
  @Bean("oracleTMF")
  public PlatformTransactionManager createOraclePTM(EntityManagerFactory factory)
  {
	  System.out.println("OracleDBConfig.createOraclePTM()");
	  return new JpaTransactionManager(factory);
  }
}
