package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {

	List<Student> loadStudents();
	void saveStudent(Student student);
}