package com.bernice.model.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
	
	public String getPalindrome(int number) {
		
	    int palindrome = number;
	    int reverse = 0;
	    
	    while (palindrome != 0) {
	    	int remainder = palindrome % 10;
	    	reverse = reverse * 10 + remainder;
	    	palindrome = palindrome / 10;
	    }
	    if (number == reverse) {
	    	return number + " is a Palindrome";
	    } else {
	    	return number + " is not a Palindrome";
	    }
	    
	}

}
