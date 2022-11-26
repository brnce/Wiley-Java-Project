package com.bernice.client;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bernice.presentation.BookPresentation;

public class BookClient {

	public static void main(String[] args) {
		
		Scanner src=new Scanner(System.in);
		
		ApplicationContext springContainer=new ClassPathXmlApplicationContext("book.xml");
		BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("presentation");
		
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=src.nextInt();
			bookPresentation.performMenu(choice);
		}

	}

}
