package com.example.student.model;

public class Student {
	private Integer id;
	private String name;
	private String email;
	private Integer age;
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
