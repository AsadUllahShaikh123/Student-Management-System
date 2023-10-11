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
		
		// checking the student id for checking either its update or adding 
		
		if(student.getId() == 0 ) {
			// insert a new record
			service.saveStudent(student);	
		}else {
			service.update(student);
		}
		
		
		
		return "redirect:/showStudent";
	}
	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		
		
		Student student = service.getStudent(id);	
		model.addAttribute("students",student);
		return "add-student";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id) {
		
		service.delete(id);
		
		return "redirect:/showStudent";
	}
	
}
