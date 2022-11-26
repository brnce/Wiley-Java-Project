package com.bernice.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.bernice")
public class BookConfiguration {
	@Bean(name="mySqlDataSource")
	public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/Catalogue");
        dataSource.setUsername("root");
        dataSource.setPassword("bernice123");
        return dataSource;
    }
	
	@Bean
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(getDataSource());
	}

}


