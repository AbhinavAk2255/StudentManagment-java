package com.example.student.model;

import jakarta.validation.constraints.*;



public class Student {
	
	private Integer id;
	
	@NotBlank(message = "Name cannot be empty or blank")
	private String name;
	
	@NotBlank(message = "Email cannot be empty or blank")
	@Email(message = "Email must be a valid email address")
	private String email;
	
	@NotNull(message = "Age cannot be null")
	@Min(value = 18, message = "Age must be at least 18")
	private Integer age;
	
	@NotBlank(message = "Course cannot be empty or blank")
	private String course;
	
	public Student() {
		
	}
	public Student(Integer id, String name, String email, Integer age, String course) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.course = course;
	}
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(Integer age) {
        this.age = age;
    }
	
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
        this.course = course;
    }
	
}
