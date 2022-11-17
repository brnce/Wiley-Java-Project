package com.student.persistence;

import java.util.Collection;

import com.student.entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();
	Student insertStudent(Student student);
	Student searchStudent(int id);
}
