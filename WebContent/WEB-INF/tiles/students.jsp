<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<table class="table table-bordered">
    <thead>
  <tr>
    <th>Name</th>
    <th>Username</th>
 
       <th>Roll Number</th>
       <th>Mobile</th>
       <th>Status</th>
       <th>edit</th>
                
  </tr> </thead>
  <c:forEach var="row" items="${student}"><tr>
    <td>${row.name}</td>
    <td>${row.username}</td>
       <td>  ${row.rollnumber}</td>
        <td>  ${row.mobile}</td>
        <td>   ${row.enabled}</td>
        <td><a href="edituser/${row.username}">Edit</a></td>
  </tr></c:forEach>
  
</table>
