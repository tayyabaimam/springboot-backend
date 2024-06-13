package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// This annotation indicates that the class is a Spring REST controller. REST controllers handle HTTP requests and return data.
@RestController
// This annotation maps HTTP requests to /api/v1/student to methods in this
// controller.
@RequestMapping(path = "api/v1/student")
public class StudentController {

	private final StudentService studentService;

	// This is an example of dependency injection, where the StudentService dependency is injected into the controller.
	//used for dependency injection. It allows Spring to automatically resolve and inject the appropriate beans into a class's fields, methods, or constructors. This promotes loose coupling and better modularization within the application. 
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// This annotation maps HTTP GET requests to this method. When a GET request is
	// made to /api/v1/student, this method is called.
	@GetMapping
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping
	public void registerNewStudent(@RequestBody Student student){
		studentService.addNewStudent(student);
	}

	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId){
		studentService.deleteStudent(studentId);
	}
}
