package com.amdocs.project.studentapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseUtilsImpl implements CourseUtils {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "system";
	private static final String password = "root";
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	
	@Override
	public boolean addCourse(Course course) {
		boolean courseAdded = false;
		try {
		//STEP 1
			
		Class.forName(driverClassName);
		conn = DriverManager.getConnection(URL, username, password);
		
		String query = "insert into course_app_table (c_name, c_duration, c_fee) values (?,?,?)";
		//STEP 2
		pst = conn.prepareStatement(query);
		pst.setString(1, course.getC_name());
		pst.setInt(2, course.getC_duration());
		pst.setInt(3, course.getC_fee());
		
		//STEP 3
		int rows = pst.executeUpdate();
		
		if(rows > 0)
			courseAdded = true;
		
		//STEP 4
		pst.close();
		conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Problem in connection...");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Problem in loading the driver class..");
		}
		return courseAdded;
	}

	@Override
	public boolean deleteCourse(int c_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Course updateCourse(Course course) {
		try {
		//STEP 1
			
		Class.forName(driverClassName);
		conn = DriverManager.getConnection(URL, username, password);
		
		String query = "update course_app_table SET c_name=?, c_duration=?, c_fee=? WHERE c_id=?";
		//STEP 2
		pst = conn.prepareStatement(query);
		pst.setString(1, course.getC_name());
		pst.setInt(2, course.getC_duration());
		pst.setInt(3, course.getC_fee());
		pst.setInt(4, course.getC_id());
		
		//STEP 3
		int rows = pst.executeUpdate();
		
		if(rows > 0)
			course = getCourse(course.getC_id());
		
		//STEP 4
		pst.close();
		conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Problem in connection...");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Problem in loading the driver class..");
		}
		return course;
	}

	@Override
	public Course getCourse(int c_id) {
		Course course = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(URL, username, password);
			
			String query = "select * from course_app_table WHERE c_id = ?";
			pst = conn.prepareStatement(query);
			pst.setInt(1, c_id);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				course = new Course();
				course.setC_id(rs.getInt(1));
				course.setC_name(rs.getString(2));
				course.setC_duration(rs.getInt(3));
				course.setC_fee(rs.getInt(4));
			}
			
			rs.close();
			pst.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		Course course = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(URL, username, password);
			
			String query = "select * from course_app_table";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				course = new Course();
				course.setC_id(rs.getInt(1));
				course.setC_name(rs.getString(2));
				course.setC_duration(rs.getInt(3));
				course.setC_fee(rs.getInt(4));
				courses.add(course);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return courses;
	}

}
