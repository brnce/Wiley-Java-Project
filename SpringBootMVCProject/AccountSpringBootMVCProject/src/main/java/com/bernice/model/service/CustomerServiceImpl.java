package com.bernice.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernice.entity.Customer;
import com.bernice.model.persistence.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;

	@Override
	public boolean loginCheck(Customer customer) {
		try {
			Customer cust = customerDao.findByAccountIdAndUserPassword(customer.getAccountId(), customer.getUserPassword());
			if(cust!=null)
				return true;
			return false;
		}
		catch(Exception ex) {
			return false;
		}
	
	}

	@Override
	public Customer searchById(int accountId) {
		
		return customerDao.findById(accountId).orElse(null);
	}
	
	@Override
	public Customer transferFunds(int myAccountId, int recepientAccountId, double amount) {
		Customer customer=customerDao.findById(myAccountId).get();
		if(customer.getBalance()<amount)
			return null;
		else {
			Customer recepient=customerDao.findById(recepientAccountId).orElse(null);
			if(recepient!=null) {
				recepient.setBalance(recepient.getBalance()+amount);
				customer.setBalance(customer.getBalance()-amount);
				customerDao.save(recepient);
				customerDao.save(customer);
				return customer;
			}
			else
				return null;
			
		}
			
		
	}

	
//	@Override
//	public boolean transferFunds(int id1, int id2, double amount) {
//		if(customerDao.updateBalance(id1, amount) > 0 && customerDao.updateBalance(id2, -amount) > 0)
//			return true;
//		else
//			return false;
//	}


}
