package service;

import java.util.Collection;


import entity.Book;
import lombok.Setter;
import persistence.BookDao;
import persistence.BookDaoImpl;


public class BookServiceImpl implements BookService {
	
//	private BookDao bookDao= new BookDaoImpl();
	
	//Service will request persistence layer for all data needs
	@Setter
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
	public boolean deleteBook(int id) {
		if(bookDao.deleteRecord(id)>0)
			return true;
		return false;
	}

}
