package com.bernice.model.service;


import com.bernice.entity.Customer;


public interface CustomerService {

	
	boolean loginCheck (Customer customer);
	
	Customer searchById (int accountId);
	
	Customer transferFunds(int myAccountId,int recepientAccountId,double amount);
	
//	boolean transferFunds(int id1, int id2, double amount);
	
}
