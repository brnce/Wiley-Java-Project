package com.bernice.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bernice.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {

}