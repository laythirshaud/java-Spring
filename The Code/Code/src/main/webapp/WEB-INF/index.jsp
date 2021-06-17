<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/app.js"></script>
</head>
<body>

<form method="POST" action="/login">

<div style ="text-align: center">
<p style="color:red "><c:out value= "${error}"/> </p>
<p><br>What is the code</p> <br>
<input type="text" name="username">

<button>Try Code</button>
</div>
</form>



</body>
</html>