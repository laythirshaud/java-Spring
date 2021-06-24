<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New person</h1>
<form:form action="/persons/new" method="post" modelAttribute="person">
    <p>
        <form:label path="firstName">firstName</form:label>
        <form:input path="firstName"/>
        <form:errors path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">lastName</form:label>
        <form:input path="lastName"/>
        <form:errors path="lastName"/>
    </p>

  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>