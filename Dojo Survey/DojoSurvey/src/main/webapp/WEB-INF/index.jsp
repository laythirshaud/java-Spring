<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<center>
	<div class="all">
		<form action="/login" method="POST">
			<label>Your Name:</label> <input type="text" name="name"> <br>
			<label>Dojo Location:</label> <select name="SanJose" id="#">
				<option value="SanJose">San Jose</option>
				<option value="jenin">jenin</option>
                <option value="any">any</option>
			</select> <br> 
			<label>Favaret Languge:</label> <select name="python" id="#">
				<option value="python">python</option>
				<option value="Javascript">Javascript</option>
                <option value="Java">Java</option>
                <option value="PHP">PHP</option>
			</select> <br> <label>Comment(optional)</label> <br>
			<textarea name="comment" rows="10px" cols="50px"></textarea>
			<br>
			<button class="but">Button</button>
		</form>
	</div>
</center>
</body>
</html>