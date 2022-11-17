package com.student.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.student.presentation.StudentPresentation;

public class StudentClient {

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		// XML configuration 
		
		ApplicationContext springContainer=new ClassPathXmlApplicationContext("studentconfiguration.xml");
		StudentPresentation studentPresentation = (StudentPresentation)springContainer.getBean("studentPresentation");
		
		while(true) {
			studentPresentation.showMenu();
			System.out.print("Enter choice : ");
			int choice = scr.nextInt();
			studentPresentation.performMenu(choice);
		}
		
		//the order of construction is DAO (Persistence) >> Service >> Presentation
		
	}
}
