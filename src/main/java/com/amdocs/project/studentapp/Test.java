package com.amdocs.project.studentapp;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		CourseUtils util = new CourseUtilsImpl();

		/*
		 * Course course = new Course(0, "Java Core", 6, 12000);
		 * 
		 * 
		 * if(util.addCourse(course)) {
		 * System.out.println("Course added successfully..!"); }else {
		 * System.out.println("Something went wrong..!"); }
		 */

		// Course course = util.getCourse(101);

		/*
		 * if(course != null) { System.out.println(course); }else {
		 * System.out.println("Course not found..!"); }
		 */

		
		  //List<Course> courses = util.getAllCourses();
		  
		  //for(Course course : courses) { System.out.println(course.getC_name()); }
		 
		/*
		 * Course course = new Course(102, "Java Script", 3, 14500); Course
		 * updatedCourse = util.updateCourse(course);
		 * 
		 * if(updatedCourse != null) { System.out.println(updatedCourse.getC_name());
		 * System.out.println(updatedCourse.getC_fee()); }
		 */
		  StudentUtils utils = new StudentUtilsImpl();
		  Student student = utils.getStudent(200);
		  if(student != null) {
			  System.out.println(student.getS_name());
			  System.out.println(student.getS_email());
			  System.out.println(student.getCourse().getC_name());
			  System.out.println(student.getCourse().getC_fee());
		  }
	}

}
