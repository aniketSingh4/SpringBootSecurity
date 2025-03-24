package org.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.security.model.Student;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController 
{
	//Adding student data into Student list
	private List<Student> students = new ArrayList<>(List.of(
			new Student(12221,"Aman Soni","Java Full Stack"),
			new Student(12222,"Neeraj Goyat","Python Full Stack")));
	@GetMapping("/")
	public String home()
	{
		return "Hello This is Spring Security Project.";
	}
	
	@GetMapping("/students")
	public List<Student> getStudent()
	{
		return students;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student)
	{
		students.add(student);
		return student;
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getcsrfToken(HttpServletRequest request)
	{
		return (CsrfToken) request.getAttribute("_csrf");
		
	}

}
