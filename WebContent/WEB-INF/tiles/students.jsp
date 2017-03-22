<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

<%-- <sql:query dataSource="jdbc/spring" var="result">
SELECT * from semester;
</sql:query> --%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">
 <p align="right">   <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#addStudent">Add User</button>
</p>



<table class="table table-bordered">
	<thead>
		<tr>
			<th>Sr.No </th>
			<th>Name</th>
			<th>Username</th>

			<th>Roll Number</th>
			<th>Mobile</th>
			<th>Status</th>
		 
			<th>delete</th>
			<th>edit</th>
		</tr>
	</thead>
	<c:forEach var="row" items="${student}" varStatus="loop" >
		<tr>
		  <td> ${loop.count }</td>
			<td>${row.name}</td>
			<td>${row.username}</td>

			<td>${row.rollnumber}</td>
			<td>${row.mobile}</td>
			<td>${row.enabled}</td>
			 
			<td><button class="btn btn-danger" data-href="deleteStudent/${row.student_id}" data-toggle="modal" data-target="#confirm-delete">
        Delete record
    </button></td>
			<td><a class="btn btn-info"  href="studentedit/<c:out value='${row.student_id}'/>">Edit Record</a></td>
			

		</tr>
	</c:forEach>

</table>
<tag:paginate max="15" offset="${offset}" count="${count}"
   uri="${pageContext.request.contextPath}/students" next="&raquo;" previous="&laquo;" />
  <!-- Modal Delete User-->

<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
            
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
                </div>
         
                
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-danger btn-ok">Delete</a>
                </div>
            </div>
        </div>
    </div>



 <%--  <!-- Modal Add User-->
  <div class="modal fade" id="addStudent" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add User</h4>
        </div>
        <div class="modal-body">
         <sf:form method="post" action="${pageContext.request.contextPath}/added-students" commandName="addStudent">
<table>
<tr><td>Name</td> <td>    <sf:input path="name" name="name" type="text"/><br/> <sf:errors path="name" cssClass="formError"></sf:errors></td></tr>
<tr><td>Username </td><td><sf:input path="username" name="username" type="text" /><br/> <sf:errors path="username" cssClass="formError"> </sf:errors></td> </tr>
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
<sf:select name="semester_id" path="semester_id">
 <c:forEach var="rowsr" items="${result.rows}">
 
		<option value="${rowsr.semester_id}">${rowsr.semester_id}</option>
			</c:forEach>
</sf:select>

 </td> </tr>
<tr>
<td><label>Select Image : </label></td>
<td><input type="file" name="image" value="test.jpg"/></td>
</tr>
<tr><td><input value="Add User" type="submit" class="btn btn-success"></td> </tr>
</table>

</sf:form>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
 --%>

    <script>
        $('#confirm-delete').on('show.bs.modal', function(e) {
            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
            
            $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
        });
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    
