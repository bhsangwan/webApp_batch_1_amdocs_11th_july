package com.amdocs.project.studentapp;

import java.util.List;

public interface StudentUtils {

	public boolean addStudent(Student student);
	public Student getStudent(int s_id);
	public List<Student> getAllStudents();
	public boolean deleteStudent(int s_id);
	public Student updateStudent(Student student);
	
}
