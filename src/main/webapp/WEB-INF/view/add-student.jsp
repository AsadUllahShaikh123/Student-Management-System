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
	<div align="center">
		<h1>Add Student</h1>
		<form:form action="saveStudent" modelAttribute="students" method="POST">
			<label>Name:</label>
			<form:input path="name" />

			<label>Mobile :</label>
			<form:input path="mobile" />

			<label>Country:</label>
			<form:input path="country" />

			<input type="submit" value="submit" />
		</form:form>
	</div>
</body>
</html>