package com.student.database;

import java.util.LinkedHashMap;
import java.util.Map;

import com.student.entity.Student;

public class StudentDatabase {
	//keeps data persistent by only having one copy of it (static - only one instance allowed)
	static private Map<Integer, Student> studentList = new LinkedHashMap<Integer, Student>();
	
	static {
		studentList.put(101, new Student(101, "StudentOne", 10));
		studentList.put(102, new Student(102, "StudentTwo", 11));
		studentList.put(103, new Student(103, "StudentThree", 40));
		studentList.put(104, new Student(104, "BStudentFour",  60));
		studentList.put(105, new Student(105, "StudentFive",  19));
	}
	
	public static Map<Integer, Student> getStudentList()  {
		return studentList;
	}
}
