<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Student Page Coming Soon .....</h1>
	<div align="center">
	<form action="addStudent">
		<input type="submit" value="Add"/>
	</form>
		<table border="1">

			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>
				</tr>
			</thead>

			<c:forEach var="student" items="${ students }">
				<tr>
					<td>${ student.id }</td>
					<td>${ student.name }</td>
					<td>${ student.mobile }</td>
					<td>${ student.country }</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>