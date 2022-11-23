package com.bernice.service;


import java.util.Collection;

import com.bernice.entity.Employee;
import com.bernice.entity.EmployeePaySlip;
import com.bernice.persistence.EmployeeDao;
import com.bernice.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	//Service will request persistence layer for all data needs
	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public Collection<Employee> getAllEmployees() {
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployeeById(int id) {
		return employeeDao.searchRecord(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(employeeDao.insertRecord(employee)>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		if(employeeDao.deleteRecord(id)>0)
			return true;
		return false;
	}

	@Override
	public boolean incrementSalary(int id, double increment) {
		if(employeeDao.updateSalary(id,increment)>0)
			return true;
		return false;
	}

	/*
	 * Business Rule
	 * AllowancesA : 18% of salary
	 * AllowanceB : 12% of salary
	 * Deduction : 8% of salary
	 */
	@Override
	public EmployeePaySlip generatePaySlip(int employeeId) {
		Employee employee=employeeDao.searchRecord(employeeId);
		if(employee!=null) {
			double allowanceA=.18*employee.getEmpSalary();
			double allowanceB=.12*employee.getEmpSalary();
			double deduction=.08*employee.getEmpSalary();
			double totalSalary=employee.getEmpSalary()+allowanceA+allowanceB-deduction;
			
			EmployeePaySlip employeePaySlip=new EmployeePaySlip(employee, allowanceA, allowanceB, deduction,totalSalary);
			return employeePaySlip;
		}
		return null;
		
	}

}

