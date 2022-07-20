package com.amdocs.project.studentapp;

import java.util.Objects;

public class Student {

	private int s_id;
	private String s_name;
	private String s_email;
	private Course course;
	
	public Student() {}

	public Student(int s_id, String s_name, String s_email, Course course) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_email = s_email;
		this.course = course;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_email() {
		return s_email;
	}

	public void setS_email(String s_email) {
		this.s_email = s_email;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public String toString() {
		return s_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(course, s_email, s_id, s_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(course, other.course) && Objects.equals(s_email, other.s_email) && s_id == other.s_id
				&& Objects.equals(s_name, other.s_name);
	}
	
	
}
