package com.bernice.model.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.bernice.entity.Employee;
import com.bernice.entity.EmployeePaySlip;

public interface EmployeeService {

	Collection<Employee> getAllEmployees();
	
	Employee searchEmployeeById(int id);
	
	boolean addEmployee(Employee employee);
	
	boolean deleteEmployee(int id);
	
	boolean incrementSalary(int id,double increment);
	
	EmployeePaySlip generatePaySlip(int employeeId);
	
	List<Employee> getEmployeesByDepartment(String deptt);
	
	List<Employee> searchByDesignation(String designation);
	
	boolean deleteEmployeeByName(String name);

}