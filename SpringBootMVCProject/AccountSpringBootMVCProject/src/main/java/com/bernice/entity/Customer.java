package com.bernice.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Customer")
public class Customer {
	
	@Id
	private int accountId;
	private String customerName;
	private String address;
	private String phoneNumber;
	private String userPassword;
	private double balance;
	

}
