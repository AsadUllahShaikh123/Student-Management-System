<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<h1 align="center">Student Page Coming Soon .....</h1>
	<div class="container">
		<form action="addStudent">
			<button class="btn btn-primary mb-2" type="submit">Add Student</button>
		</form>
		<table class="table">

			<thead class="table-dark">
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
					<td><a class="btn btn-primary"
						href="updateStudent?userId=${ student.id }" role="button">Update</a>
					<td><a class="btn btn-danger" href="deleteStudent?userId=${ student.id }"
						onclick="
							if(! confirm('Are you sure  you want to delete this student? ')) return false
							
							" role="button">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>