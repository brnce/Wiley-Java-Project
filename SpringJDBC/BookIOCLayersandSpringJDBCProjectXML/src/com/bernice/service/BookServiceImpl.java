package com.bernice.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bernice.entity.Book;
import com.bernice.persistence.BookDao;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

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
		if (bookDao.insertBook(book)>0)
			return true;
		return false;
		
	}
	
	@Override
	public boolean updateCopies(int id, int increment) {
		if (bookDao.updateCopies(id, increment) > 0)
			return true;
		return false;
	}


	@Override
	public boolean deleteBook(int id) {
		if(bookDao.deleteRecord(id)>0)
			return true;
		return false;
	}

}
