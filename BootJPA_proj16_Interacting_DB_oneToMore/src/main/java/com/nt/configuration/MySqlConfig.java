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
@EnableJpaRepositories(basePackages="com.nt.repo.promotion",entityManagerFactoryRef="mySqlEMF",transactionManagerRef="mySqlPMT")
public class MySqlConfig
{
  @Bean("mySqlDs")
  @ConfigurationProperties(prefix="mysql.datasource")
  public DataSource createMySqlDs()
  {
	  return DataSourceBuilder.create().build();
  }
  @Bean("mySqlEMF")
  public LocalContainerEntityManagerFactoryBean createMySqlEMF(EntityManagerFactoryBuilder builder)
  {
	 Map<String,String> props= new HashMap();
	 props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	 props.put("hibernate.hbm2ddl.auto","update");
	 return builder.dataSource(createMySqlDs()).
			 packages("com.nt.model.promotion").
			 properties(props).build();
  }
  public PlatformTransactionManager createMySqlPTM(EntityManagerFactory factory)
  {
	  return new JpaTransactionManager(factory);
  }
}
