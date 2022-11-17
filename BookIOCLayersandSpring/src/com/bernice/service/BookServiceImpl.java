package com.bernice.service;

import java.util.Collection;

import com.bernice.entity.Book;
import com.bernice.persistence.BookDao;

public class BookServiceImpl implements BookService {
	
	private BookDao bookDao;
	
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book searchBookById(int id) {
		return bookDao.searchBook(id);
	}

	@Override
	public boolean addNewBook(Book book) {
		Book bk = bookDao.searchBook(book.getBookId()); //checking if book exists
		if (bk!= null) {
			return false;
		}
		bookDao.insertBook(book);
		return true;
	}

	@Override
	public boolean deleteBook(int id) {
		Book book = bookDao.deleteRecord(id);
		if(book!=null) {
			return true;
		}
		return false;
	}

}
