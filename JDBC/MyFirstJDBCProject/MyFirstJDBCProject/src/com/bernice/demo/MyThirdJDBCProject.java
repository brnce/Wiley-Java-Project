package com.bernice.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyThirdJDBCProject {

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
			preparedStatement=connection.prepareStatement("INSERT INTO DEPARTMENTS VALUES(?,?,?,?)");
			
			System.out.println("Enter Department ID : ");
			preparedStatement.setInt(1, scanner.nextInt());
			
			System.out.println("Enter Department Name : ");
			preparedStatement.setString(2, scanner.next());
			
			System.out.println("Enter Department Manager ID : ");
			preparedStatement.setInt(3, scanner.nextInt());
			
			System.out.println("Enter Department Location ID : ");
			preparedStatement.setInt(4, scanner.nextInt());
			
			
			
			//DML : executeUpdate() , which will int (count of no of rows manipulated by the query)
			int rows=preparedStatement.executeUpdate();
			
//			3. Process The result
			if(rows>0)
				System.out.println("Employee Added Successfuly!");
			else
				System.out.println("Employee Not Added!");
			
		} catch (ClassNotFoundException e) {
			//displaying the complete stack for exceptions
			e.printStackTrace();
		}
		catch(SQLException e) {
			System.out.println("Employee Not Added!");
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