<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
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
	<h1>
		Welcome,
		<c:out value="${user.firstname}" />
	</h1>
	<a style="float: right;" href="/logout">Logout</a>
	<p>hear are same of the events in your states</p>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/State</th>

			</tr>
		</thead>
		<c:forEach items="${eventsIn}" var="event">
			<tr>
				<th><a href="/events/${event.id}"><c:out
							value="${event.name}" /></a></th>
				<td><fmt:formatDate pattern="MMMM dd, yyyy"
						value="${event.date}" /></td>
				<td><c:out value="${event.city}" /></td>
				<td><c:out value="${event.host.first_name}" /></td>
				<td><c:choose>
						<c:when test="${event.host.id==user.id}">
							<a href="/events/${event.id}/edit">Edit</a>
							<a href="/events/${event.id}/delete">Delete</a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${event.attendees.contains(user)}">

									<span>Joined <a href="/events/${event.id}/cancel">Cancel</a></span>
								</c:when>
								<c:otherwise>
									<a href="/events/${event.id}/join">Join</a>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>
	<p>hear are same of the events in your states</p>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/State</th>

			</tr>
		</thead>
		<c:forEach items="${eventsOut}" var="l">
			<tr>
				<th><a href="/events/${e.id}"><c:out value="${e.name}" /></a></th>
				<td><fmt:formatDate pattern="MMMM dd, yyyy" value="${e.date}" /></td>
				<td><c:out value="${e.city}" /></td>
				<td><c:out value="${e.host.first_name}" /></td>
				<td><c:choose>
						<c:when test="${e.host.id==user.id }">
							<a href="/events/${e.id}/edit">Edit</a>
							<a href="/events/${e.id}/delete">Delete</a>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${e.attendees.contains(user)}">
									<span>Joined <a href="/events/${event.id}/cancel">Cancel</a></span>
								</c:when>
								<c:otherwise>
									<a href="/events/${e.id}/join">Join</a>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

	<h2>Create an Event</h2>
	<form:form action="/event" method="post"
		modelAttribute="/events/create">
		<form:hidden path="host" value="${user.id}" />
		<p>
			<form:label path="name">name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="Date">Date</form:label>
			<form:errors path="Date" />
			<form:textarea path="Date" />
		</p>
		<p>
			<form:label path="location">location</form:label>
			<form:errors path="location" />
			<form:input path="location" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>