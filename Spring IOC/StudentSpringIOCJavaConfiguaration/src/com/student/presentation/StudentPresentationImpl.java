package com.student.presentation;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entity.Student;
import com.student.service.StudentService;

@Component("studentPresentation")
public class StudentPresentationImpl implements StudentPresentation {

	private StudentService studentService;
	
	@Autowired
//	@Qualifier("service")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("Student Management System");
		System.out.println("1. List All Students");
		System.out.println("2. Add Student");
		System.out.println("3. Exit");
		System.out.println("============================");

	}


	@Override
	public void performMenu(int choice) {
		Scanner scr = new Scanner(System.in);

		switch (choice) {
		case 1:
			Collection<Student> books = studentService.getAllStudents();
			for (Student book : books) {
				System.out.println(book);
			}
			break;

		case 2:
			Student newStudent = new Student();
			System.out.print("Enter Student ID : ");
			newStudent.setStudentId(scr.nextInt());
			System.out.print("Enter Student name: ");
			newStudent.setStudentName(scr.next());
			System.out.print("Enter Student grade : ");
			newStudent.setGrade(scr.nextInt());

			if (studentService.addNewStudent(newStudent))
				System.out.println("Student added!");
			else
				System.out.println("Student " + newStudent.getStudentId() + " exists.");
			break;
			
		case 3:
			System.out.println("Thanks for using the student system!");
			System.exit(0);
			
		default:
			System.out.println("Unknown input");
			break;
		}
	}
}
