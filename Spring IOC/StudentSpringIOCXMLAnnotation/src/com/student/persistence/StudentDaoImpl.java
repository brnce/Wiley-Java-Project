package com.student.persistence;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.student.database.StudentDatabase;
import com.student.entity.Student;

@Component("dao")
public class StudentDaoImpl implements StudentDao{
	
	@Override
	public Collection<Student> getAllStudents() {
		return StudentDatabase.getStudentList().values();
	}

	@Override
	public Student insertStudent(Student student) {
		return StudentDatabase.getStudentList().put(student.getStudentId(), student);
	}

	@Override
	public Student searchStudent(int id) {
		return StudentDatabase.getStudentList().get(id);
	}
}
