package com.example.student.model;

public class StudentAnalytics {
	
	private Integer totalStudents;
	private double averageAge;
	private String mostPopularCourse;
	
	public StudentAnalytics() {
		// default constructor
	}
	
	
	public StudentAnalytics(Integer totalStudents, double averageAge, String mostPopularCourse) {
		
		this.totalStudents = totalStudents;
		this.averageAge = averageAge;
		this.mostPopularCourse = mostPopularCourse;
		
	}
	
	public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Integer totalStudents) {
        this.totalStudents = totalStudents;
    }

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }

    public String getMostPopularCourse() {
        return mostPopularCourse;
    }

    public void setMostPopularCourse(String mostPopularCourse) {
        this.mostPopularCourse = mostPopularCourse;
    }
	
    
	
}
