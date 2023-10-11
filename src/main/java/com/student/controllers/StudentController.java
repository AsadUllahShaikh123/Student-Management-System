package com.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.model.Student;
import com.student.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	@GetMapping("/showStudent")
	public String ShowStudentList(Model model) {
		
		List<Student> studentList = service.loadStudents();	
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
		
		service.saveStudent(student);
		return "redirect:/showStudent";
	}
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		
		
		Student student = service.getStudent(id);	
		model.addAttribute("students",student);
		return "add-student";
	}
	
}
