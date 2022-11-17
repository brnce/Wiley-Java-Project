package com.student.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.entity.Student;
import com.student.persistence.StudentDao;


@Component("service")
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public StudentServiceImpl(@Autowired StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Collection<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public Student searchStudentById(int id) {
		return studentDao.searchStudent(id);
	}

	@Override
	public boolean addNewStudent(Student student) {
		Student bk = studentDao.searchStudent(student.getStudentId()); // checking if book exists
		if (bk != null) {
			return false;
		}
		studentDao.insertStudent(student);
		return true;
	}

}
