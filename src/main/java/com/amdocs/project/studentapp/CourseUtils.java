package com.amdocs.project.studentapp;

import java.util.List;

public interface CourseUtils {

	public boolean addCourse(Course course) ;
	public boolean deleteCourse(int c_id);
	public Course updateCourse(Course course);
	public Course getCourse(int c_id);
	public List<Course> getAllCourses();
	
}
