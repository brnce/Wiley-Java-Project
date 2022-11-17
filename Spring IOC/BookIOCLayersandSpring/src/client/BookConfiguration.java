package client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import persistence.BookDaoImpl;
import presentation.BookPresentationImpl;
import service.BookServiceImpl;


@Configuration
@ComponentScan(basePackages = {"persistence", "presentation", "service"})
public class BookConfiguration {

}
