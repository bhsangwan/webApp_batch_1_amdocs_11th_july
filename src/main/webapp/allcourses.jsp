<%@page import="com.amdocs.project.studentapp.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Available Courses</h2>
	<%
		List<Course> courses = (List<Course>)request.getAttribute("all_courses");
	%>
	<table>
		<tr>
			<th>Course ID</th>
			<th>Course Name</th>
			<th>Course Duration</th>
			<th>Course Fee</th>
		</tr>
		<%
			for(Course course : courses){
		%>
			<tr>
				<td><%=course.getC_id() %></td>
				<td><%=course.getC_name() %></td>
				<td><%=course.getC_duration() %></td>
				<td><%=course.getC_fee() %></td>
			</tr>
		<%
			}
		%>
	</table>
	
	
	
</body>
</html>