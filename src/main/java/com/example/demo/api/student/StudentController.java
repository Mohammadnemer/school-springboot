package com.example.demo.api.student;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllAdmins(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable long id) {
		return studentService.getStudent(id);
	}
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentService.createStudent(student);
	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@Valid @RequestBody Student student , @PathVariable long id) {
		return studentService.updateStudent(student, id);
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable long id){
		return studentService.deleteStudent(id);
	}
}
