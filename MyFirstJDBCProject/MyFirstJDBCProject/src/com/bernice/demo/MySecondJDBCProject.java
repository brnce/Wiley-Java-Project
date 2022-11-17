package com.bernice.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MySecondJDBCProject {

	public static void main(String args[]) {

		Connection connection=null;
		PreparedStatement preparedStatement;
		Scanner scanner=new Scanner(System.in);
		try {
//			1. Connect
//			1.1 Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			1.2 Connect to the Database
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Company", "root", "Characterised123");
			
//			2. Query
			preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEES VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			
			System.out.println("Enter Employee ID : ");
			preparedStatement.setInt(1, scanner.nextInt());
			
			System.out.println("Enter Employee First Name : ");
			preparedStatement.setString(2, scanner.next());
			
			System.out.println("Enter Employee Last Name : ");
			preparedStatement.setString(3, scanner.next());
			
			System.out.println("Enter Employee email : ");
			preparedStatement.setString(4, scanner.next());
			
			System.out.println("Enter Employee phone number : ");
			preparedStatement.setString(5, scanner.next());
			
			System.out.println("Enter Employee hire date (YYYY-MM-DD) : ");
			preparedStatement.setString(6, scanner.next());
			
			System.out.println("Enter Employee job ID : ");
			preparedStatement.setString(7, scanner.next());
			
			System.out.println("Enter Employee Salary : ");
			preparedStatement.setDouble(8, scanner.nextDouble());
			
			System.out.println("Enter Employee Commission : ");
			preparedStatement.setDouble(9, scanner.nextDouble());
			
			System.out.println("Enter Employee manager ID : ");
			preparedStatement.setInt(10, scanner.nextInt());
			
			System.out.println("Enter Employee department ID : ");
			preparedStatement.setInt(11, scanner.nextInt());
			
			
			//DML : executeUpdate() , which will int (count of no of rows manipulated by the query)
			int rows=preparedStatement.executeUpdate();
			
//			3. Process The result
			if(rows>0)
				System.out.println("Employee added");
			else
				System.out.println("Employee Not added");
			
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("Employee Not added");
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