package com.bernice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@Table(name = "Books")
public class Book {

	@Id
	@Column(name = "BOOKID")
	private int bookId;
	
	@Column(name = "TITLE")
	private String bookName;
	
	@Column(name = "AUTHOR_NAME")
	private String authorName;
	
	@Column(name = "NUMOFCOPIES")
	private int noOfCopies;
	
	
}