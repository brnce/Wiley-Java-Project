package com.bernice.persistence;

import java.util.Collection;

import com.bernice.database.BookDatabase;
import com.bernice.entity.Book;

public class BookDaoImpl implements BookDao{
	
	//no constructor? - dao doesn't need a constructor because it doesn't depend on any other layer (?)

	@Override
	public Collection<Book> getAllBooks() {
		return BookDatabase.getBookList().values();
	}

	@Override
	public Book searchBook(int id) {
		return BookDatabase.getBookList().get(id);
	}

	@Override
	public Book insertBook(Book book) {
		return BookDatabase.getBookList().put(book.getBookId(), book);
	}

	@Override
	public Book deleteRecord(int id) {
		return BookDatabase.getBookList().remove(id);
	}
	
	
	

}