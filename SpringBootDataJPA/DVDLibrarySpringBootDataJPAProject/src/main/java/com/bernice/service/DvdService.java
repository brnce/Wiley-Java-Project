package com.bernice.service;

import java.util.Collection;

import com.bernice.entity.DVD;

public interface DvdService {
	
	Collection<DVD> getAllDVDs(); // get list of all dvd's in collection
	
	DVD searchDVDbyID(int id); // view a DVD by their id 
	
//	DVD searchDVDbyTitle(String title); // search a DVD by it's title
	
	boolean addDVD(DVD dvd); // add a new DVD 
	
	boolean deleteDVD(int id); // delete a DVD
	
	boolean editDVD(DVD dvd); // edit a DVD
}

