package com.bernice.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.bernice.presentation.BookPresentation;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookClient {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		ApplicationContext springContainer=new ClassPathXmlApplicationContext("bookconfiguration.xml");
		BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("bookPresentation");
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			bookPresentation.performMenu(choice);
		}

	}

}
