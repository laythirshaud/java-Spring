<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/dashboord" style="float: right;">dashboord</a>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${topyou}" var="l">
			<tr>
				<td><a href="/looki/${l.id}">${l.title}</a></td>
				<td><c:out value="${l.rating}" /></td>
				<td><a href="/looki/${l.id}/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>