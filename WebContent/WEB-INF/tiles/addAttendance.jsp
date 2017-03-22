<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<script src="${pageContext.request.contextPath}/static/js/attendance.js"></script>

 <link type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-timepicker.min.css" />
  <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/bootstrap-timepicker.min.js"></script>
 

<link href="${pageContext.request.contextPath}/static/css/attStyle.css"
	rel="stylesheet">

<p>Welcome Teacher Portal</p>
 
 <!-- <div style="width:100%; ">
		  
			<label style=" margin-left:1%; margin-top:1%; font-weight:lighter;">
				Start Time :
			</label>			
			<input style="width:120px;   margin-left:2px;" id="stepExample1" type="text" class="time ui-timepicker-input" name="start_time" required="required" autocomplete="off">
	
			<label style=" margin-left:5%; margin-top:1%; font-weight:lighter;">
				End Time :
			</label>	
			<input style="width:120px;  margin-top:-12px; margin-left:2px;" id="stepExample2" type="text" class="time ui-timepicker-input" name="end_time" required="required" autocomplete="off">
			
		</div> -->

 
 
        
<div class='alert alert-success' id="success-alert">
	Add Attendance: <strong>${param.AttSuccess}</strong>
</div>
<script>
	$("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
		$("#success-alert").slideUp(500);
	});
</script>

<sql:query dataSource="jdbc/spring" var="result"> 
SELECT * from student,tech_sub where  tech_sub.sub_id=1 AND tech_sub.user_id='3';
</sql:query>



<table border="1" width="80%" class="attendence_table">
 

<tr>
	<c:forEach var="row" items="${result.rows}" varStatus="rowCount">
		<form action="${pageContext.request.contextPath}/addAtt" method="post"
			id="abc${row.student_id}" >
			
		<td class="present" id="att${row.rollnumber}"
			onclick="tdClick(this.id)" title="${row.name}"><abbr title="">${row.rollnumber}</abbr>
			<input type="hidden" value="${row.sub_id}" name="sub_id"> <input
			type="hidden" value="1" id="stdatt${row.rollnumber}" class="std"
			name="status"> <input type="hidden" value="${row.student_id}"
			name="student_id"></td>

		  
 
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> 
	
		 
	</form>
 
<%-- 	 <c:if test="${rowCount.index%7==0 and rowCount.index!=0}"></tr><tr></c:if> 
 --%>  	 <c:if test="${rowCount.count%4==0 and rowCount.index!=0}"></tr><tr></c:if> 
  
	</c:forEach>
 		  
 
	

	<tr>
		<div
			style="width: 70%; height: 15%; margin-top: 2%; margin-bottom: -0%; padding-left:80px;">

			<input type="button"
				class="btn btn-success btn-lg"
				id="all_present" value="Present All" onclick="allPresent()">

			<input type="button"
				class="btn btn-danger btn-lg "
				id="all_absent" value="Absent All" onclick="allAbsent()">
				
				 
				<span style="float:right;">   <button class="btn btn-primary btn-lg"> Add Attendance</button></span>   

 <script>

function post_form_data(data) {
    $.ajax({
        type: 'POST',
        url: 'addAtt',
        data: data,
        success: function () { location.href = "${pageContext.request.contextPath}/addAttendance";  },
        error: function () {}
    });
}

$('button').on('click', function () {
	 
    $('form').each(function () {
        post_form_data($(this).serialize());
    });
});

$("#haha").click(function(){
    alert("The paragraph was clicked.");
});
$(document).ready(function(){
    $("p").click(function(){
        alert("The paragraph was clicked.");
    });
});
</script>

<p>Click on this paragraph.</p>
		</div>

	</tr>
</table>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 -->
 <script src="http://code.jquery.com/jquery-1.12.1.min.js"></script>
 
<!--    <script type="text/javascript" src="http://www.sbbusba.edu.pk/cms_new/teacher/timepicker/lib/site.js"></script>
  <link rel="stylesheet" type="text/css" href="http://www.sbbusba.edu.pk/cms_new/teacher/timepicker/lib/site.css" />
  <script type="text/javascript" src="http://www.sbbusba.edu.pk/cms_new/teacher/timepicker/jquery.timepicker.js"></script>
  <link rel="stylesheet" type="text/css" href="http://www.sbbusba.edu.pk/cms_new/teacher/timepicker/jquery.timepicker.css" />
<script>
                $(function() {
                    $('#stepExample1').timepicker({ 'step': 15 });
					$('#stepExample2').timepicker({ 'step': 15 });
                    
                });
</script> -->