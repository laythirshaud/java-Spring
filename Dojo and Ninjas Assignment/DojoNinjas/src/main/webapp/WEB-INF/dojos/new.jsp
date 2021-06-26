<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Dojo</title>
</head>
<body>
    <h1>New Dojo</h1>
    <form:form action="/dojos" method="POST" modelAttribute="dojo"> 
        <p>Name: <form:input path="name" /></p>
        <input type="submit" value="Create">
    </form:form>
</body>
</html>