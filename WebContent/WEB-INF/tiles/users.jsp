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
			<td><button class="btn btn-danger" data-href="delete/${row.username}" data-toggle="modal" data-target="#confirm-delete">
        Delete record
    </button></td>
			<td><a class="btn btn-info"  href="useredit/<c:out value='${row.username}'/>">Edit Record</a></td>
			

		</tr>
	</c:forEach>

</table>

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


    


    <script>
        $('#confirm-delete').on('show.bs.modal', function(e) {
            $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
            
            $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
        });
    </script>
