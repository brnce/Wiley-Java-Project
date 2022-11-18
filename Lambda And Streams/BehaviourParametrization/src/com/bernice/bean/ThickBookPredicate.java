package com.bernice.bean;

public class ThickBookPredicate implements BookPredicate {

	@Override
	public boolean test(Book book) {
		
		return book.getNoOfPages()>5000;
	}

}
