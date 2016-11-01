<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">

<table class="table table-bordered">
	<thead>
		<tr>
			<th>Name</th>
			<th>Username</th>

			<th>Roll Number</th>
			<th>Mobile</th>
			<th>Status</th>
			<th>Role</th>
			<th>delete</th>
			<th>edit</th>
		</tr>
	</thead>
	<c:forEach var="row" items="${user}">
		<tr>
			<td>${row.name}</td>
			<td>${row.username}</td>

			<td>${row.rollnumber}</td>
			<td>${row.mobile}</td>
			<td>${row.enabled}</td>
			<td>${row.authority}</td>
			<td><a href="delete/${row.username}">delete</a></td>
			<td><a href="useredit/<c:out value='${row.username}'/>">edit</a></td>
			

		</tr>
	</c:forEach>

</table>
