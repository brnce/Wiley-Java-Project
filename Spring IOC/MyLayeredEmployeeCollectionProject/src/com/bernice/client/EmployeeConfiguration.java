package com.bernice.client;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bernice.persistence.EmployeeDao;
import com.bernice.persistence.EmployeeDaoImpl;
import com.bernice.presentation.EmployeePresentationImpl;
import com.bernice.service.EmployeeServiceImpl;



@Configuration
@ComponentScan(basePackages = "com.bernice")
public class EmployeeConfiguration {

	
}
