<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>Edit  ${event.name}</legend>
<div>
    <p><form:errors path="event.*"/></p>

    <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name" />
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
        </p>
        <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>

            <form:select path="state">
                <form:option value="WB">WB</form:option>
                <form:option value="CA">CA</form:option>
                <form:option value="AD">AD</form:option>
                <form:option value="BD">BD</form:option>
            </form:select>
        </p>
        <input type="submit" value="Edit Event!"/>
    </form:form>
        <a href="/events">Back</a>
</div>
</fieldset>
</body>
</html>