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
	<h1>Create a new course</h1>
	<form:form method="POST" action="/courses/update"
		modelAttribute="course">
		<form:input path="id" type="hidden" />
		<form:input path="users" type="hidden" />
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name"  /></td>
				<td><form:errors path="name" /></td>
			</tr>

			<tr>
				<td><form:label path="instructor">Instructor:</form:label></td>
				<td><form:input path="instructor" /></td>
				<td><form:errors path="instructor" /></td>
			</tr>
			<tr>
				<td><form:label path="capacity">Capacity:</form:label></td>
				<td><form:input path="capacity"  /></td>
				<td><form:errors path="capacity" /></td>
			</tr>
		</table>

		<input type="submit" value="Update" />

	</form:form>


</body>
</html>