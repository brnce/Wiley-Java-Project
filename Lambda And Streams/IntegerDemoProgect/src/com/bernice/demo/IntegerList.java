package com.bernice.demo;


// class excersise

import java.util.Arrays;
import java.util.List;

public class IntegerList {
	public static void main(String[] args) {
		List<Integer> numbers=Arrays.asList(3, -64, 77, 23, 300, -12);
		

		long negNumbers=numbers.stream().filter((n)->n<0).count();
		// printing out all the negative integers
		System.out.println("Total negative integers = " + negNumbers);
	}
}