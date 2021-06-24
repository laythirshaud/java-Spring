<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New License</h1>
<form:form action="/licenses" method="post" modelAttribute="licens">

    <p>
        <form:label path="expirationDate">ExpirationDate</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date"  path="expirationDate"/>
    </p>
    <p>
        <form:label path="state">state</form:label>
        <form:errors path="state"/>
        <form:textarea path="state"/>
    </p>
 <p>
        <form:label path="person">person</form:label>
        
        
        <form:select path="person">
        	<c:forEach items="${persons}" var="person">
            <form:option value="${person}">${person.firstName } ${person.lastName }</form:option>
            </c:forEach>
        </form:select>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>