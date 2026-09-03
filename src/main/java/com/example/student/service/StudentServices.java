package com.example.student.service;

import com.example.student.model.Student;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

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
		
		for(Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
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
	
	
	
	
	
	
	
	
	
	
}
