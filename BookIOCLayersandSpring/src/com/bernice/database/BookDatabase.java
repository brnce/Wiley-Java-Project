package com.bernice.database;

import java.util.LinkedHashMap;
import java.util.Map;

import com.bernice.entity.Book;

public class BookDatabase {
	//keeps data persistent by only having one copy of it (static - only one instance allowed)
	static private Map<Integer, Book> bookList = new LinkedHashMap<Integer, Book>();
	
	static {
		bookList.put(101, new Book(101, "Book One", "Author One", 10));
		bookList.put(102, new Book(102, "Book Two", "Author Four", 11));
		bookList.put(103, new Book(103, "Book Three", "Author Two", 40));
		bookList.put(104, new Book(104, "Book Four", "Author Three", 60));
		bookList.put(105, new Book(105, "Book Five", "Author Five", 19));
	}
	
	public static Map<Integer, Book> getBookList()  {
		return bookList;
	}
}
