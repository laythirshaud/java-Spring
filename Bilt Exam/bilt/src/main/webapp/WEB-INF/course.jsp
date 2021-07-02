<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a style="float: right;" href="/logout">Logout</a>
	<h1>Create a new course</h1>
	

	<form:form method="POST" action="/courses/new" modelAttribute="course">
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name" class="input" /></td>
				<td><form:errors path="name" /></td>
			</tr>

			<tr>
				<td><form:label path="instructor">Instructor:</form:label></td>
				<td><form:input path="instructor"  /></td>
				<td><form:errors path="instructor" /></td>
			</tr>
			<tr>
				<td><form:label path="capacity">Capacity:</form:label></td>
				<td><form:input path="capacity" type="number" /></td>
				<td><form:errors path="capacity" /></td>
			</tr>
		</table>
		
		<br>

		<input type="submit" value="Create" />

	</form:form>
</body>
</html>