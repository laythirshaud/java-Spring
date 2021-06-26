<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Ninja</title>
</head>
<body>
    <h1>New Ninja</h1>
    <form:form action="/ninjas" method="POST" modelAttribute="ninja"> 
        <p>
            Dojo:
            <form:select path="dojo">
                <c:forEach items="${dojos}" var="d">
                    <form:option value="${d}">
                        ${d.name} Location
                    </form:option>
                </c:forEach>
            </form:select>
        </p>
        <p>First Name: <form:input path="firstName" /></p>
        <p>Last Name: <form:input path="lastName" /></p>
        <p>Age: <form:input path="age" /></p>
        <input type="submit" value="Create">
    </form:form>
</body>
</html>