package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import entity.Book;
import persistence.BookDaoImpl;

class BookDaoTest {
	
	BookDaoImpl bookDaoImpl;

	@BeforeEach
	void setUp() throws Exception {
		bookDaoImpl=new BookDaoImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
		bookDaoImpl=null;
	}

	@DisplayName("Get All Books")
	@Test
	void testGetAllBooks() {
		assertTrue(bookDaoImpl.getAllBooks().size()>0);
	}
	
	@DisplayName("Insert Books")
	@Test
	void testInsertBook() {
		assertEquals(1, bookDaoImpl.insertBook(new Book(106,"Book Six","Author Six", 550)));
	}
	
	@DisplayName("Search Book by ID")
	@Test
	void testSearchBook() {
		assertTrue(bookDaoImpl.searchBook(103)!=null);
		
	}
	
	@DisplayName("Delete Books")
	@Test
	void testDeleteRecord() {
		assertEquals(1, bookDaoImpl.deleteRecord(107));
	}
}
