package com.bernice.persistence;

import java.util.Collection;

import com.bernice.entity.Book;



public interface BookDao {

	Collection<Book> getAllBooks();
	Book searchBook(int id);
	int insertBook(Book book);
	int deleteRecord(int id);
	int updateCopies(int id, int increment);
}