package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.dao.StudentDao;
import com.student.model.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDao dao;
	@GetMapping("/showStudent")
	public String ShowStudentList(Model model) {
		
		List<Student> studentList = dao.loadStudents();	
		model.addAttribute("students",studentList);
		return "student-list";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		
		Student student = new Student();
		
		model.addAttribute("students",student);
		
		return "add-student";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(Student student) {
		
		System.out.print(student);
		
		dao.saveStudent(student);
		return "redirect:/showStudent";
	}
	
}
