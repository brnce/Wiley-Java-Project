package com.bernice.persistence;

import java.util.Collection;
import com.bernice.database.EmployeeDataBase;
import com.bernice.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	
	
	@Override
	public Collection<Employee> getAllRecords() {
		return EmployeeDataBase.getEmployeeList().values();
	}

	@Override
	public Employee searchRecord(int id) {
		return EmployeeDataBase.getEmployeeList().get(id);
		
	}

	@Override
	public Employee insertRecord(Employee employee) {
		return EmployeeDataBase.getEmployeeList().put(employee.getEmpId(), employee);
	}
	
	@Override
	public Employee deleteRecord(int id) {
		
		return EmployeeDataBase.getEmployeeList().remove(id);
	}


	@Override
	public Collection<Employee> searchDepartmentName() {
	
		return EmployeeDataBase.getEmployeeList().values();
	}
}
