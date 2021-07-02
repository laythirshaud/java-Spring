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
<a style="float: right;" href="/logout">Logout</a>
			<h1 class="title">
				Welcome,
				<c:out value="${user.name}" />
			</h1>

			<h2>Courses :</h2> 
		
		<table >
			<thead >
				<tr>
					<td>Course</td>
					<td>Instructor</td>
					<td>Signups</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${courses}" var="course">
				<tr>
					<td><a href="/courses/${course.id}">${course.name}</a></td>
					<td>${course.instructor}</td>
					<td>${course.getUsers().size()} / ${course.capacity}</td>
					<td>
					<c:choose>
						<c:when test="${course.getUsers().indexOf(user)!= -1}">
							Already Added
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${course.getUsers().size() == course.capacity}">
									Full
								</c:when>
								<c:otherwise>
									<a href="/courses/add/${course.id}">Add</a>
								</c:otherwise>
							</c:choose>	
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<br>
		<br>

			<a href="/courses/new">Add Course</a>
</body>
</html>