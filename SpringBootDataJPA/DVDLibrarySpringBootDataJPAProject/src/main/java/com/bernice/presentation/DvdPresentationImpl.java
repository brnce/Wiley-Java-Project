package com.bernice.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collection;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.bernice.entity.DVD;
import com.bernice.service.DvdService;

@Component("presentation")
public class DvdPresentationImpl implements DvdPresentation {
	
	@Autowired
	private DvdService dvdService;
	
	@Autowired
	@Qualifier("service")
	public void setDvdService(DvdService dvdService) {
		this.dvdService = dvdService;
	}
	
	@Override
	public void showMenu() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Main Menu");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("DVD Library Management System");
		System.out.println("1. List All DVD in Collection");
		System.out.println("2. Search DVD By ID"); // title
		System.out.println("3. Add New DVD in Collection");
		System.out.println("4. Edit a DVD Collection");
		System.out.println("5. Delete a DVD Collection");
		System.out.println("6. Exit");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		
		case 1: 
			Collection<DVD> dvds = dvdService.getAllDVDs();
			for(DVD dvd : dvds) { 
				System.out.println(dvd);
			}
			System.out.println(" ");
			break;
		case 2: 
			System.out.println("Enter DVD ID : ");
			int id=scanner.nextInt();
			DVD dvd=dvdService.searchDVDbyID(id);
			if(dvd!=null)
				System.out.println(dvd);
			else
				System.out.println("DVD with ID " + id + " does not exist");
			break;
		case 3: 
			DVD newDvd = new DVD();
			
			System.out.println("Enter DVD ID: ");
			newDvd.setDvdID(scanner.nextInt());
			
			System.out.println("Enter DVD Title: ");
			newDvd.setTitle(scanner.next());
			
			System.out.println("Enter DVD release date (dd-Mon-yyyy): ");
			DateTimeFormatter df=new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("dd-MMM-yyyy")).toFormatter();
			
			newDvd.setReleaseDate(LocalDate.parse(scanner.next(),df));
			
			System.out.println("Enter DVD MPAA Rating (e.g. PG-13, R, NC-17.... : ");
			newDvd.setRating(scanner.next());
			
			System.out.println("Enter Director's Name: ");
			newDvd.setDirectorName(scanner.next());
			
			System.out.println("Enter Movie Production Studio: ");
			newDvd.setStudio(scanner.next());
			
			System.out.println("Enter any comments about the movie: ");
			newDvd.setRatingComments(scanner.next());
			
			if(dvdService.addDVD(newDvd))
				System.out.println("DVD Collection Added");
			else
				System.out.println("DVD with ID "+newDvd.getDvdID()+" already exist, so cannot add it as a new DVD to collection!");
			
			break;
		case 4: 
			System.out.println("This functionality is still to be added");
			break;
		case 5: 
			System.out.println("Enter DVD ID : ");
			int dId=scanner.nextInt();
			if(dvdService.deleteDVD(dId))
				System.out.println("DVD with ID " + dId + " has been deleted");
			else
				System.out.println("DVD with ID " + dId + " does not exist");
			break;
		case 6: 
			System.out.println("Thanks for using our DVD Collection System");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
			
		}
	}
	
}
	
