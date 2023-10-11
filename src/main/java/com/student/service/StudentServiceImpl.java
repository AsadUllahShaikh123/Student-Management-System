package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;
	@Override
	public List<Student> loadStudents() {
		List<Student> studentList = dao.loadStudents();
		return studentList;
	}
	
	public void saveStudent(Student student) {
		dao.saveStudent(student);
	}
	
	public Student getStudent(int id) {
		Student student = dao.getStudent(id);
		return student;
	}

}
