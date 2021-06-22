<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/dashboord" style="float: right;">dashboord</a>
<div style="padding: 100px">
<p>Title :  <c:out value="${looki.title}"/></p>
<p>Artist : <c:out value="${looki.artist}"/></p> 
<p>Rating : <c:out value="${looki.rating}"/></p>

<form action="/looki/${id}/delete" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</div>
</body>
</html>