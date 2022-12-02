package com.bernice.demo;

import java.util.Scanner;
import javax.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.bernice.presentation.EmployeePresentation;

@SpringBootApplication(scanBasePackages = "com.bernice")
@EntityScan(basePackages = "com.bernice.entity")
@EnableJpaRepositories(basePackages = "com.bernice.persistence")

public class EmployeeSpringBootDataJPAProject {

	public static void main(String[] args) {
		ApplicationContext springContainer= SpringApplication.run(EmployeeSpringBootDataJPAProject.class, args);
		Scanner scanner=new Scanner(System.in);

		EmployeePresentation employeePresentation=(EmployeePresentation)springContainer.getBean("presentation");
		
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
		}

	
	}

}
