<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style2.css">
</head>
<body>
	<h3>your gold</h3>
	<h3>${gold}</h3>
	<div id="box">
		<div class="any_box">
			<h2>farm</h2>
			<p>(earns 10-20 golds)</p>
			<form action="/find" method="POST">
				<input type="hidden" name="hidden" value="farm"> <input
					type="submit" value="find Gold">
			</form>
		</div>
		<div class="any_box">
			<h2>cave</h2>
			<p>(earns 5-10 golds)</p>
			<form action="/find" method="POST">
				<input type="hidden" name="hidden" value="cave"> <input
					type="submit" value="find Gold">
			</form>
		</div>
		<div class="any_box">
			<h2>house</h2>
			<p>(earns 2-5 golds)</p>
			<form action="/find" method="POST">
				<input type="hidden" name="hidden" value="house"> <input
					type="submit" value="find Gold">
			</form>
		</div>

		<div class="any_box">
			<h2>casino</h2>
			<p>(earns -50-50 golds)</p>
			<form action="/find" method="POST">
				<input type="hidden" name="hidden" value="casino"> <input
					type="submit" value="find Gold">
			</form>
		</div>
	</div>

	<div>
		<h3>activate :</h3>
		<br>
		<div class="coller">
			<c:forEach items="${arr}" var="value">
				<p>${value}</p>
			</c:forEach>
		</div>

	</div>

</body>
</html>