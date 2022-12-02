package com.bernice.demo;

import java.time.LocalDate;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.bernice.entity.DVD;
import com.bernice.persistence.DvdDao;
import com.bernice.presentation.DvdPresentation;


@SpringBootApplication(scanBasePackages = "com.bernice")
@EntityScan(basePackages = "com.bernice.entity")
@EnableJpaRepositories(basePackages = "com.bernice.persistence")
public class DvdLibrarySpringBootDataJpaProjectApplication {

	public static void main(String[] args) {
		
		ApplicationContext springContainer = SpringApplication.run(DvdLibrarySpringBootDataJpaProjectApplication.class, args);
		
		Scanner scanner=new Scanner(System.in);
		
		DvdPresentation dvdPresentation =(DvdPresentation)springContainer.getBean("presentation");
		DvdDao dao=(DvdDao)springContainer.getBean("dvdDao");
		 
		 dao.save(new DVD(001, "Titanic", LocalDate.of(1998, 01, 23), "PG-12", "James Cameron", "20th Century Studios", "This movie will always be special"));
		 dao.save(new DVD(002, "Avatar", LocalDate.of(2009, 12, 10), "PG-12", "James Cameron", "20th Century Studios", "Classic!!!"));
		 dao.save(new DVD(003, "The Woman King", LocalDate.of(2022, 10, 04), "PG-13", "Gina Prince-Bythewood", "Sony Pictures", "Woman Power 101"));
		 dao.save(new DVD(004, "Twilight", LocalDate.of(2008, 12, 03), "PG-12", "Catherine Hardwicke", "Summit Entertainment", "This was the highlight of my teenage years"));
		
		while(true) {
			dvdPresentation.showMenu();
			System.out.println("Enter Choice: ");
			int choice=scanner.nextInt();
			dvdPresentation.performMenu(choice);
			
		}
	}

}

