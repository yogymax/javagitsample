package com.api.exp.config;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = {"com.api.exp.*"})
public class SpringORMConfig extends WebMvcConfigurationSupport{

	static {
		System.out.println("Spring ORM. Configuration Loaded..");
	}
	
	
/**
 * 
 *  to convert - java to json -- 
 *  		to serialize directly -- simple and complex [user defined types..]	
 * @return
 */
	
	  @Bean
	  public ObjectMapper getObjectMapper() {
	    return new ObjectMapper();
	  }

	  @Bean
	  public MappingJackson2HttpMessageConverter messageConverter() {
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setObjectMapper(getObjectMapper());
	    return converter;
	  }

	  @Override
	  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    converters.add(messageConverter());
	    addDefaultHttpMessageConverters(converters);
	  }

	
	@Bean("ds")
	public DataSource basicDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/restapi");
		datasource.setUsername("root");
		datasource.setPassword("root");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return datasource;
	}
	
	public Properties iniHibernateProperties() {
		Properties props = new Properties();
		props.put(Environment.HBM2DDL_AUTO,"update");
		props.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
		props.put(Environment.SHOW_SQL,true);
		return props;
	}
	
	@Bean("sfactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean lbean = new LocalSessionFactoryBean();
		lbean.setDataSource(basicDataSource());
		lbean.setHibernateProperties(iniHibernateProperties());
		lbean.setPackagesToScan("com.api.exp.entities");
		return lbean;
	}
	
}
