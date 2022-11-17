package com.student.service;

import java.util.Collection;
import java.util.List;

import com.student.entity.Student;

public interface StudentService {

	Collection<Student> getAllStudents(); //list all books
	
	Student searchStudentById(int id); //search book id
	
	boolean addNewStudent(Student student);//add new book
	
		
}
