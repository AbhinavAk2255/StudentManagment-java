package com.example.student.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.student.service.StudentServices;
import com.example.student.model.Student;
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
		Student student = studentServices.getStudenttById(id);
		
		if (student == null) {
			
			return ResponseEntity
					.status(404)
					.body("Student with ID " + id + " not found");
		}
		return ResponseEntity.status(200)
				.body(student);
	}
	
	
	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody Student student) {
		
		Student newStudent = studentServices.addSrudent(student);
		return ResponseEntity
                .status(201)
                .body(newStudent);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
		
		Student updateStudent = studentServices.updateStudent(id,  student);
		if (updateStudent == null) {
            return ResponseEntity
                    .status(404)
                    .body("Student with ID " + id + " not found");
        }
		return ResponseEntity
				.status(201)
				.body(updateStudent);
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {

        boolean deleted = studentServices.deleteStudent(id);

        if (!deleted) {
            return ResponseEntity
                    .status(404)
                    .body("Student with ID " + id + " not found");
        }

        return ResponseEntity.ok("Student deleted successfully");
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
