package com.code.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories("com.code.dao")
class ApplicationConfiguration {

	 @Bean
	 public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	      LocalContainerEntityManagerFactoryBean em 
	        = new LocalContainerEntityManagerFactoryBean();
	      em.setDataSource(dataSource());
	      em.setPackagesToScan(new String[] { "com.code" });

	      JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	      em.setJpaVendorAdapter(vendorAdapter);
	      em.setJpaProperties(additionalProperties());
	      return em;
	 }
	 @Bean
	 public DataSource dataSource(){
	     DriverManagerDataSource dataSource = new DriverManagerDataSource();
	     dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	     dataSource.setUrl("jdbc:mysql://localhost:3306/test");
	     dataSource.setUsername( "root" );
	     dataSource.setPassword( "" );
	     return dataSource;
	 }
	 @Bean
	 public PlatformTransactionManager transactionManager() {
	     JpaTransactionManager transactionManager = new JpaTransactionManager();
	     transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
	     return transactionManager;
	 }
	
	 @Bean
	 public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	     return new PersistenceExceptionTranslationPostProcessor();
	 }
	 Properties additionalProperties() {
	     Properties properties = new Properties();
	     properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	     properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	     return properties;
	}
	 
}