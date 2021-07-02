<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}
table {
  border-collapse: collapse;
  width: 100%;
}
th, td {
  padding: 15px;
}
</style>
<body>
<div>
		<div >
			<h1 >
				<c:out value="${course.name}" />
			</h1>
		</div>

		<div>
			<h2>
				Instructor:
				<c:out value="${course.instructor}" />
			</h2>
			<h2>Sign Ups: ${course.getUsers().size() }</h2>
		</div>

	

		<table>
			<thead >
				<tr>
					<td>Student Name</td>
					<td>Sign Up Date</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${course.getUsers()}" var="user">
					<tr>
						<td>${user.name}</td>
						<td><fmt:formatDate value="${user.createdAt}"
								pattern="MM/dd/yyyy HH:mm:ss a" /></td>

					
						<td><a href="/courses/${course.id}/delete">Remove</a></td>
						
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<br>


		<a href="/courses/${course.id}/edit">Edit</a> 
		
		<a style="margin-left: 120px" href="/courses/delete/${course.id}">Delete</a>


	</div>
</body>
</html>