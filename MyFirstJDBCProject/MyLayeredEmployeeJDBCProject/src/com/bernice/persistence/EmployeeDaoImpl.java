package com.bernice.persistence;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import com.bernice.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Collection<Employee> getAllRecords() {

		Connection connection = null;
		PreparedStatement preparedStatement;

		Collection<Employee> employeeList = new ArrayList<Employee>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "Characterised123");

			preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("EMPLOYEEID");
				String name = resultSet.getString("NAME");
				String desig = resultSet.getString("DESIGNATION");
				String deptt = resultSet.getString("DEPARTMENT");
				double sal = resultSet.getDouble("SALARY");
				LocalDate doj = resultSet.getDate("DOJ").toLocalDate();

				employeeList.add(new Employee(id, name, desig, deptt, sal, doj));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employeeList;
	}

	@Override
	public Employee searchRecord(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement;

		Employee employee = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "Characterised123");

			preparedStatement = connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEEID=?");

			preparedStatement.setInt(1, id);
			
            // result set is pointing above first row
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int eid = resultSet.getInt("EMPLOYEEID");
				String name = resultSet.getString("NAME");
				String desig = resultSet.getString("DESIGNATION");
				String deptt = resultSet.getString("DEPARTMENT");
				double sal = resultSet.getDouble("SALARY");
				LocalDate doj = resultSet.getDate("DOJ").toLocalDate();

				employee = new Employee(eid, name, desig, deptt, sal, doj);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return employee;

	}

	

	@Override
	public Employee insertRecord(Employee employee) {
		return null;
	}

	@Override
	public Employee deleteRecord(int id) {

		return null;
	}

}
