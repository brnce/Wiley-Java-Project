package com.bernice.service;

import java.util.Collection;
import java.util.List;
import com.bernice.entity.Book;



public interface BookService {
	
	Collection<Book> getAllBooks(); //list all books
	
	Book searchBookById(int id); //search book id
	
	boolean addNewBook(Book book);//add new book
	
	List<Book> searchBookByTitle(String bookName); // search book by title
	
	boolean deleteBook(int id); //delete a book
	
	boolean updateCopies(int id, int increment); //update number of copies
	
}
