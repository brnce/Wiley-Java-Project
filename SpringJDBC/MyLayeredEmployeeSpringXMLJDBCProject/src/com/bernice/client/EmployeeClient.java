package com.bernice.client;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bernice.presentation.EmployeePresentation;


public class EmployeeClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ApplicationContext springContainer=new ClassPathXmlApplicationContext("employee.xml");
		EmployeePresentation employeePresentation=(EmployeePresentation)springContainer.getBean("presentation");
		
		while(true) {
			employeePresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeePresentation.performMenu(choice);
		}

	}

}