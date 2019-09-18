package com.miracle.awt;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Component
public class Config {
	
	/*
	 * @Bean
	 * 
	 * @ConfigurationProperties("spring.datasource") public HikariDataSource
	 * dataSource() { return
	 * DataSourceBuilder.create().type(HikariDataSource.class).build(); }
	 * 
	 * @Bean public EntityManagerFactory entityManagerFactory() {
	 * 
	 * 
	 * JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	 * 
	 * LocalContainerEntityManagerFactoryBean emf = new
	 * LocalContainerEntityManagerFactoryBean();
	 * emf.setDataSource(this.dataSource()); emf.setJpaVendorAdapter(vendorAdapter);
	 * emf.setPackagesToScan("com.miracle.jwt");
	 * emf.setPersistenceUnitName("default"); emf.afterPropertiesSet(); return
	 * emf.getObject(); }
	 */

}
