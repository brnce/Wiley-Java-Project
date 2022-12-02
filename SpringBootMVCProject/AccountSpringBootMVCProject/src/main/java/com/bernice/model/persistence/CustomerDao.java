package com.bernice.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bernice.entity.Customer;


@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	public Customer findByAccountIdAndUserPassword(int accountID, String userPassword);
	
	@Modifying
	@Transactional
	@Query("update Customer set balance=balance-:amt where accountId=:id")
	int updateBalance(@Param("id") int id, @Param("amt") double amount);

}
