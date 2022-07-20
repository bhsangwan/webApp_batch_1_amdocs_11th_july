<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = (String)request.getAttribute("user");
	%>

	Hi <b><%=username %></b> ! Welcome to the application..!<br>
	
	<a href="view_all_courses">View Courses</a> 
	<a href="course_form.jsp">Add New Course</a>
	
	
</body>
</html>