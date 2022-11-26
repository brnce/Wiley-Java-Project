package com.bernice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Book {

	private int bookId;
	private String bookName;
	private String authorName;
	private int noOfCopies;
	
	
}