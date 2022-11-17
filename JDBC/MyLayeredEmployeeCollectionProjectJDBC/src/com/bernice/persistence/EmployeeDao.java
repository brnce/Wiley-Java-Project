package com.bernice.persistence;

import java.util.Collection;


import com.bernice.entity.Employee;

/*
 * DAO : Data Access Object : Design Pattern to design persistence layer
 */
public interface EmployeeDao {

	Collection<Employee> getAllRecords();
	Employee searchRecord(int id);
	Employee insertRecord(Employee employee);
	Employee deleteRecord(int id);
	Collection<Employee> searchDepartmentName();
}
