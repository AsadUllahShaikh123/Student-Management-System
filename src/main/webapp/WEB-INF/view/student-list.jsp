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
			<input type="submit" value="Add" />
		</form>
		<table border="1">

			<thead>
				<tr>
					<td>ID</td>
					<td>Name</td>
					<td>Mobile</td>
					<td>Country</td>
					<td></td>
				</tr>
			</thead>

			<c:forEach var="student" items="${ students }">
				<tr>
					<td>${ student.id }</td>
					<td>${ student.name }</td>
					<td>${ student.mobile }</td>
					<td>${ student.country }</td>
					<td><a href="updateStudent?userId=${ student.id }">Update</a></td>
					<td><a href="deleteStudent?userId=${ student.id }"
						onclick="
							if(! confirm('Are you sure  you want to delete this student? ')) return false
							
							">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>