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

import jakarta.inject.Qualifier;
import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.nt.repo.prod",entityManagerFactoryRef="oracleEMF",transactionManagerRef="oraclePTM")
public class OracleConfig 
{
  @Bean("oracleDs")
  @ConfigurationProperties(prefix="oracle.datasource")
  @Primary
  public DataSource createOracleDS()
  {
	 return DataSourceBuilder.create().build(); 
  }
  
  @Bean("oracleEMF")
  public LocalContainerEntityManagerFactoryBean createEMF(EntityManagerFactoryBuilder builder)
  {
	Map<String,String> props= new HashMap();
	props.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
	props.put("hibernate.hbm2ddl.auto", "update");
	//create LocalContainerEntityManagerFactoryBean return EntityManagerFactory
		return  builder.dataSource(createOracleDS()).
			packages("com.nt.model.prod").
			properties(props).
			build();
	 }
  
   @Bean("oraclePTM")
   @Primary
   public PlatformTransactionManager createOracleTxmgr(EntityManagerFactory factory)
   { 
	   return new JpaTransactionManager(factory);
   }
  
}
