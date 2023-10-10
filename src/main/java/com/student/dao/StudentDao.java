package com.student.dao;

import java.util.List;

import com.student.model.Student;

public interface StudentDao {

	List<Student> loadStudents();
}
