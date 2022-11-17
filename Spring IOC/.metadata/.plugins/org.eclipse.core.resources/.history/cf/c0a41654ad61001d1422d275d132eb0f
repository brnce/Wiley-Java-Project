package client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import presentation.BookPresentation;




public class BookClient {

	public static void main(String[] args) {
		
		Scanner src=new Scanner(System.in);

		ApplicationContext springContainer=new AnnotationConfigApplicationContext(BookConfiguration.class);
		
		BookPresentation bookPresentation=(BookPresentation)springContainer.getBean("bookPresentation");
		while(true) {
			bookPresentation.showMenu();
			System.out.println("Enter Choice : ");
			int choice=src.nextInt();
			bookPresentation.performMenu(choice);
		}

	}

}
