package com.student.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/showStudent")
	public String ShowStudentList() {
		
		return "student-list";
	}
	
}
