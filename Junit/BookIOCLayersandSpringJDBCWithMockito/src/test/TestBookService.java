package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import entity.Book;
import persistence.BookDao;
import service.BookServiceImpl;


class TestBookService {
	
	private BookServiceImpl bookServiceImpl;
	private BookDao bookdao;

	@BeforeEach
	void setUp() throws Exception {
		
		bookServiceImpl = new BookServiceImpl();
		
		bookdao = Mockito.mock(BookDao.class);
		
		bookServiceImpl.setBookDao(bookdao);

	}

	@AfterEach
	void tearDown() throws Exception {
		// tearDown() method that is invoked once after all test methods have been run.
		// We can use this method if we want to free the external resources which were 
		// reserved in the method annotated with the @BeforeClass annotation
	}

	@Test
	void testAddNewBook() {
		
		//Specifying the behaviour of the mock
		when(bookdao.insertBook(new Book(107, "Book Seven", "Author Seven", 230))).thenReturn(1);
		
		assertTrue(bookServiceImpl.addNewBook(new Book(107, "Book Seven", "Author Seven", 230)));
		
	}
	
	
	@Test
	void testAddNewBook2() {
		
		//Specifying the behaviour of the mock
		when(bookdao.insertBook(new Book(107, "Book Seven", "Author Seven", 230))).thenReturn(0);
		
		assertFalse(bookServiceImpl.addNewBook(new Book(107, "Book Seven", "Author Seven", 230)));
		
	}


	@Test
	void testDeleteBook() {
		
		//Specifying the behaviour of the mock
		when(bookdao.deleteRecord(105)).thenReturn(1);
		
		assertTrue(bookServiceImpl.deleteBook(105));

	}
	
	@Test
	void testDeleteBook2() {
		
		//Specifying the behaviour of the mock
		when(bookdao.deleteRecord(105)).thenReturn(0);
		
		assertFalse(bookServiceImpl.deleteBook(105));

	}

}
