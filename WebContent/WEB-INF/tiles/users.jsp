<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">
 <p align="right">   <button type="button" class="btn btn-success btn-lg" data-toggle="modal" data-target="#addUser">Add User</button>
</p>
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
			<td><button class="btn btn-danger" data-href="delete/${row.username}" data-toggle="modal" data-target="#confirm-delete">
        Delete record
    </button></td>
			<td><a class="btn btn-info"  href="useredit/<c:out value='${row.username}'/>">Edit Record</a></td>
			

		</tr>
	</c:forEach>

</table>

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



  <!-- Modal Add User-->
  <div class="modal fade" id="addUser" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add User</h4>
        </div>
        <div class="modal-body">
         <sf:form method="post" action="${pageContext.request.contextPath}/added-user" commandName="addUser">
<table>
<tr><td>Name</td> <td>    <sf:input path="name" name="name" type="text"/><br/> <sf:errors path="name" cssClass="formError"></sf:errors></td></tr>
<tr><td>Username </td><td><sf:input path="username" name="username" type="text" /><br/> <sf:errors path="username" cssClass="formError"> </sf:errors></td> </tr>
<tr><td>Roll Number </td> <td><sf:input type="text"  path="rollnumber" name="rollnumber"/> </td> </tr>
<tr><td>Password </td> <td><sf:input type="text" path="password"  name="password"/> <br/> <sf:errors path="rollnumber" cssClass="formError"></sf:errors></td> </tr>
<tr><td>Mobile </td> <td><sf:input type="text" path="mobile"  name="mobile"/> </td> </tr>
<tr><td>Authority </td> <td>
 <sf:select name="authority" path="authority">
  <option value="ROLE_STUDENT">Student</option>
  <option value="ROLE_TEACHER">Teacher</option>
</sf:select> 
 </td> </tr>
<tr><td>Currently Student? </td> <td>
<sf:select name="enabled" path="enabled">
  <option value="1">Yes</option>
  <option value="0">No</option>
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


    <script>
        $('#confirm-delete').on('show.bs.modal', function(e) {
            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
            
            $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
        });
    </script>
