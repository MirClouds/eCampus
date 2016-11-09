<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body><div class="container">
<div class="panel panel-info">
      <div class="panel-heading">
	  <h2><a href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/static/images/sbbu-logo.png" width="80" height="80"/></a>
	  Shaheed Benazir Bhutto University <span style="font-size:16px;"> - Shaheed Benazirabad</span></h2>
 <!--   <h4><span class="titleecampus">e</span>Campus - The Manager</h4>-->
 
</div>

<div class="header"> <tiles:insertAttribute name="header"></tiles:insertAttribute></div>

<div class="panel-body"><tiles:insertAttribute name="content"></tiles:insertAttribute></div>


<div class="panel-footer"> <tiles:insertAttribute name="footer"></tiles:insertAttribute></div>
</div>
</div>
</body>
</html>