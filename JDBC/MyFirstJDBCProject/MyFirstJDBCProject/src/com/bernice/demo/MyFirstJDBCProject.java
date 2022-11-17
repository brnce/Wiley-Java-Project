package com.bernice.demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MyFirstJDBCProject {

	public static void main(String args[]) {

		Connection connection=null;
		PreparedStatement preparedStatement;
		
		try {
			// 1. Connect
			// 1.1 Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 1.2 Connect to the Database
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Company", "root", "Characterised123");
			
			// 2. Query
			preparedStatement=connection.prepareStatement("SELECT * FROM EMPLOYEES");
			
			// DQL : executeQuery() , which will result ResultSet
			ResultSet resultSet= preparedStatement.executeQuery();
			
			// 3. Process The result
			while(resultSet.next()) {
				int id=resultSet.getInt("EMPLOYEE_ID");
				String firstName=resultSet.getString("FIRST_NAME");
				String lastName=resultSet.getString("LAST_NAME");
				String email=resultSet.getString("EMAIL");
				String phoneNum=resultSet.getString("PHONE_NUMBER");
				Date hireDate=resultSet.getDate("HIRE_DATE");
				String jobId=resultSet.getString("JOB_ID");
				double sal=resultSet.getDouble("SALARY");
				double comm=resultSet.getDouble("COMMISSION_PCT");
				int manId=resultSet.getInt("MANAGER_ID");
				int deptId=resultSet.getInt("DEPARTMENT_ID");
				
				
				//displaying result  
				System.out.println(id + " | " + firstName + " " + lastName + "  " + email + "  " + phoneNum + "  "
						+ hireDate + "  " + jobId + "  " + sal + "  " + comm + "  " + manId + "  " + deptId);
			}
			
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
