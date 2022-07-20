<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add Course Page</h2>
<%
	boolean courseAdded = Boolean.parseBoolean(request.getParameter("courseAdded"));
%>

<%
	if(courseAdded){
%>
	<b>Course Added Successfully..!</b>
<%
	}
%>
<form method="post" action="add_new_course">
	Course Name: <input type="text" name="c_name" placeholder="Course Name Here"><br>
	Course Duration: <input type="text" name="c_dur" placeholder="Course Duration in Months"><br>
	Course Fee: <input type="text" name="c_fee" placeholder="Course Fee in INR">
	<input type="submit" name="sbmt" value="Add Course">
</form>
</body>
</html>