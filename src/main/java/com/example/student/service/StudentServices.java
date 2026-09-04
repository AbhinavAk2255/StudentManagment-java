package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.model.StudentAnalytics;
import com.example.student.exception.ResourceNotFoundException;



import org.springframework.stereotype.Service;



import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServices {

	private final List<Student> students =  new ArrayList<>();
	private Integer nextId = 1;
	
	//	Get all students
	public List<Student> getAllstudents() {
		return students;
		
	}
	
	//	Get student by ID
	public Student getStudenttById(int id) {
		
		return students.stream()
				.filter(student -> student.getId() == id)
				.findFirst()
				.orElseThrow(() -> 
				new ResourceNotFoundException(
						"Student with ID " + id + " does not exist."
						)
				);
	}
	
	
	
	//	add new student record
	public Student addSrudent(Student student) {
		
		student.setId(nextId++);
		students.add(student);
		return student;
	}
	
	//	update Student record
	public Student updateStudent(int id, Student studentUpdatedData) {
		
		Student existingStudent = getStudenttById(id);
		if (existingStudent == null) {
			return null;
		}
		existingStudent.setName(studentUpdatedData.getName());
		existingStudent.setEmail(studentUpdatedData.getEmail());
		existingStudent.setAge(studentUpdatedData.getAge());
		existingStudent.setCourse(studentUpdatedData.getCourse());
		
		return existingStudent;
	}
	
//	Delete student record
	public boolean deleteStudent(int id) {
		
		Student student = getStudenttById(id);
		if (student == null) {
            return false;
        }
		students.remove(student);
		return true;
	}
	
	// search student by course
	public List<Student> searchByCourse(String course) {
		
		return students.stream()
				.filter(student -> 
				student.getCourse().equalsIgnoreCase(course))
				.collect(Collectors.toList());
	}
	
	
	// student analytics
	public StudentAnalytics getAnalytics() {
		
		int totalStudents = students.size();
		
		double averageAge = students.stream()
				.mapToInt(student -> student.getAge())
				.average()
				.orElse(0.0);
		
		String mostPopularCourse = students.stream()
				.collect(Collectors.groupingBy(
						student -> student.getCourse().toLowerCase(),
						Collectors.counting()
				))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.map(entry -> entry.getKey())
				.orElse("No courses");
		
		return new StudentAnalytics(
				totalStudents,
				Math.round(averageAge * 10.0) / 10.0,
				mostPopularCourse
				);
	}
	
	
	
}
