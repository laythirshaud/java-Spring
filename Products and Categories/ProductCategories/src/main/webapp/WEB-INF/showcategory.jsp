<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${category.name}</h1>
<h3>Products</h3>
<ul>
    <c:forEach items="${category.products}" var="pro">
        <li>${pro.name}</li>
    </c:forEach>
</ul>
<h3>Add Category</h3>
<form action="/addproduct/${category.id}" method="post">
    <select name="product">
        <c:forEach items="${unlisted}" var="pro">
            <option value="${pro.id}">${pro.name}</option>
        </c:forEach>
    </select>
    <input type="submit" value="add"/>
</form>
</body>
</html>