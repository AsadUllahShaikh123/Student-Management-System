package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.student.dao.StudentDao;
import com.student.model.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao dao;
	@GetMapping("/showStudent")
	public String ShowStudentList(Model model) {
		
		List<Student> studentList = dao.loadStudents();
		
		for(Student student : studentList) {
			System.out.println("Name : "+ student.getName());
		}		
		model.addAttribute("students",studentList);
		return "student-list";
	}
	
	@GetMapping("/addStudent")
	public String addStudent() {
		
		return "add-student";
	}
	
}
