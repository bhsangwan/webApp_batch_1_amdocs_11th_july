package com.amdocs.project.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.project.studentapp.Course;
import com.amdocs.project.studentapp.CourseUtils;
import com.amdocs.project.studentapp.CourseUtilsImpl;

@WebServlet("/add_new_course")
public class AddNewCourseServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_name = request.getParameter("c_name");
		int c_duration = Integer.parseInt(request.getParameter("c_dur"));
		int c_fee = Integer.parseInt(request.getParameter("c_fee"));
		
		Course course = new Course(0, c_name, c_duration, c_fee);
		
		CourseUtils util = new CourseUtilsImpl();
		if(util.addCourse(course)) {
			response.sendRedirect("course_form.jsp?courseAdded=true");
		}else {
			response.sendRedirect("course_form.jsp?courseAdded=false");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
