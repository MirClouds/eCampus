<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

<sql:query dataSource="jdbc/spring" var="result">
SELECT * from semester;
</sql:query>


<h1>Add Students</h1>
<sf:form method="post" action="${pageContext.request.contextPath}/added-students" commandName="student">

<table>
<tr><td>Name</td> <td>    <sf:input path="name" name="name" type="text"/><br/> <sf:errors path="name" cssClass="formError"></sf:errors></td></tr>
<tr><td>Username </td><td><sf:input path="username" name="username" type="text" /><br/> <sf:errors path="username" cssClass="formError"> </sf:errors><span class="formError"> ${msg}</span></td> </tr>
<tr><td>Roll Number </td> <td><sf:input type="text"  path="rollnumber" name="rollnumber"/> </td> </tr>
<tr><td>Password </td> <td><sf:input type="text" path="password"  name="password"/> <br/> <sf:errors path="rollnumber" cssClass="formError"></sf:errors></td> </tr>
<tr><td>Mobile </td> <td><sf:input type="text" path="mobile"  name="mobile"/> </td> </tr>
<tr><td>Currently Student? </td> <td>
<sf:select name="enabled" path="enabled">
  <option value="1">Yes</option>
  <option value="0">No</option>
</sf:select>

 </td> </tr>
 <tr><td>Semester </td> <td>
<sf:select name="semester_id" path="semester.semester_id">
<c:forEach var="row" items="${result.rows}">
 
		<option value="${row.semester_id}">${row.semester_id}</option>
			</c:forEach> 
</sf:select>

 </td> </tr>
<tr>
<td><label>Select Image : </label></td>
<td><input type="file" name="image" value="test.jpg"/></td>
</tr>
<tr><td><input value="Add Student" type="submit" ></td> </tr>
</table>
</sf:form>
