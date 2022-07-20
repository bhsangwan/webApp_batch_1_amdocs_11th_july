package com.amdocs.project.studentapp;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentUtilsImpl implements StudentUtils {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String username = "system";
	private static final String password = "root";
	private String driverClassName = "oracle.jdbc.driver.OracleDriver";
	
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getStudent(int s_id) {
		Student student = null;
		try {
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(URL, username, password);
			
			String query = "select s_name, s_email, c_name, c_fee from student_app_table s, course_app_table c WHERE s.c_id = c.c_id AND s_id = ?";
			pst = conn.prepareStatement(query);
			pst.setInt(1, s_id);
			
			rs = pst.executeQuery();
			Course course = null;
			if(rs.next()) {
				student = new Student();
				//student.setS_id(rs.getInt(1));
				student.setS_name(rs.getString(1));
				student.setS_email(rs.getString(2));
				course = new Course();
				course.setC_name(rs.getString(3));
				course.setC_fee(rs.getInt(4));
				student.setCourse(course);
			}
			
			rs.close();
			pst.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudent(int s_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

}
