<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
	<thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>version</th>
            <th>Action</th>
        </tr>
    </thead>
		<c:forEach items="${lang1}" var="l">
			<tr>
				<td><a href="/languages/${l.id}">${l.name}</a></td>
				<td><c:out value="${l.creator}" /></td>
				<td><c:out value="${l.version}" /></td>
				<td><a href="/languages/${l.id}/delete">Delete</a></td>
				<td><a href="/languages/${l.id}/Edit">Edit</a></td>
				
	
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

	<form:form action="/languages" method="post" modelAttribute="lang">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator" />
			<form:textarea path="creator" />
		</p>
		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version" />
			<form:input path="version" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>