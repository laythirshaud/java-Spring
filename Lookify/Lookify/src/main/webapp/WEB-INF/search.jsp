<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, td, th {  
  border: 1px solid #ddd;
  text-align: left;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  padding: 15px;
}
</style>
<body>
<a href="/dashboord" style="float: right;">dashboord</a>
<h1>Songs By <c:out value="${searchValue}"/> </h1>
<form action="/song/searcher" method="POST">
  <label for="search">search:</label>
  <input type="text" id="search" name="search">
  <input type="submit" value="Search">
</form>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${searchResult}" var="l">
			<tr>
				<td><a href="/looki/${l.id}">${l.title}</a></td>
				<td><c:out value="${l.rating}" /></td>
				<td><a href="/looki/${l.id}/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
</body>
</html>