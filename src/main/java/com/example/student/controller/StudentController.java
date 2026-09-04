package com.example.student.controller;

import java.util.*;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student.service.StudentServices;

import jakarta.validation.Valid;

import com.example.student.model.Student;
import com.example.student.model.StudentAnalytics;
import com.example.student.service.StudentServices;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	private final StudentServices studentServices;
	
	public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
	
	//	GET method
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		
		return ResponseEntity.ok(studentServices.getAllstudents());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable int id) {
		
		return ResponseEntity.ok(
                studentServices.getStudenttById(id)
        );
	}
	
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
		
		Student newStudent = studentServices.addSrudent(student);
		return ResponseEntity
                .status(201)
                .body(newStudent);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
		
		Student updateStudent = studentServices.updateStudent(id,  student);

		return ResponseEntity
				.status(201)
				.body(updateStudent);
	}
	
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        boolean deleted = studentServices.deleteStudent(id);


        return ResponseEntity.ok("Student deleted successfully");
    }
	
	@GetMapping("/search")
	public ResponseEntity<List<Student>> searchStudents(@RequestParam String course) {
		
		return ResponseEntity.ok(
                studentServices.searchByCourse(course)
        );
	}
	
	
	@GetMapping("/analytics")
    public ResponseEntity<StudentAnalytics> getAnalytics() {

        return ResponseEntity.ok(
                studentServices.getAnalytics()
        );
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
