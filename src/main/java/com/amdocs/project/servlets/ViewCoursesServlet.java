package com.amdocs.project.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.project.studentapp.*;

@WebServlet("/view_all_courses")
public class ViewCoursesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseUtils util = new CourseUtilsImpl();
		List<Course> courses = util.getAllCourses();
		request.setAttribute("all_courses", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("allcourses.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
