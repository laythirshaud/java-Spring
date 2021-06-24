<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>..............</h1>
<c:out value="${person.getFirstName()} ${person.getLastName()}"></c:out>
<br>
<h1>..........</h1>

<c:out value="${person.license.state}"></c:out>

<c:out value="${lice.number}"></c:out> <br>
 <c:out value="${lice.expirationDate}"></c:out>
 </body>
</html>