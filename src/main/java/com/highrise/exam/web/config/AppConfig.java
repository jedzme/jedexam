package com.highrise.exam.web.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.highrise.exam.web.service", "com.highrise.exam.web.controller", "com.highrise.exam.web.dao" })
@PropertySource("config.properties")
@EnableJpaRepositories("com.highrise.exam.web.repository")
public class AppConfig {

	private static final String PROPERTY_DB_DRIVER = "db.driver";
	private static final String PROPERTY_DB_PASSWORD = "db.password";
	private static final String PROPERTY_DB_USERNAME = "db.username";
	private static final String PROPERTY_DB_URL = "db.url";

	private static final String PROPERTY_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_HIBERNATE_EJB_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

	private static final String ENTITY_PACKAGE_TO_SCAN = "com.highrise.exam.web.entity";

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_DB_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_DB_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_DB_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_DB_PASSWORD));

		return dataSource;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGE_TO_SCAN);
		entityManagerFactoryBean.setJpaProperties(getJpaProperties());

		return entityManagerFactoryBean;
	}

	private Properties getJpaProperties() {
		Properties properties = new Properties();

		properties.put(PROPERTY_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_HIBERNATE_DIALECT));
		properties.put(PROPERTY_HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(PROPERTY_HIBERNATE_HBM2DDL_AUTO));
		properties.put(PROPERTY_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_HIBERNATE_SHOW_SQL));
		properties.put(PROPERTY_HIBERNATE_EJB_NAMING_STRATEGY,
				env.getRequiredProperty(PROPERTY_HIBERNATE_EJB_NAMING_STRATEGY));
		properties.put(PROPERTY_HIBERNATE_FORMAT_SQL, env.getRequiredProperty(PROPERTY_HIBERNATE_FORMAT_SQL));

		return properties;
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
