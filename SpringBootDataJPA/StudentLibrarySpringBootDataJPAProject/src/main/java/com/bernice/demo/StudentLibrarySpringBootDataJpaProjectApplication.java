package com.bernice.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bernice.presentation.BookPresentation;

@SpringBootApplication(scanBasePackages = "com.bernice")
@EntityScan(basePackages = "com.bernice.entity")
@EnableJpaRepositories(basePackages = "com.bernice.persistence")
public class StudentLibrarySpringBootDataJpaProjectApplication {

	public static void main(String[] args) {
		
		Scanner src = new Scanner(System.in);
		
		ApplicationContext springContainer = SpringApplication.run(StudentLibrarySpringBootDataJpaProjectApplication.class, args);
		
		BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("presentation");
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=src.nextInt();
			bookPresentation.performMenu(choice);
		}
	}

}
