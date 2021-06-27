<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${productFromController.name}</h1>
	<h3>Categories</h3>
	<ul>
		<c:forEach items="${productFromController.categories}" var="cat">
			<li>${cat.name}</li>
		</c:forEach>
	</ul>
	<h3>Add Category</h3>
	<form action="/addcategory/${productFromController.id}" method="post">
		<select name="category">
			<c:forEach items="${unlisted}" var="cate">
				<option value="${cate.id}">${cate.name}</option>
			</c:forEach>
		</select> <input type="submit" value="add" />
	</form>
</body>
</html>