<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">eCampus</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath}"><span class="glyphicon glyphicon-home"></span> Home</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-education"></span> Departments</a></li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-list"></span> Students
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/students">Students List</a></li>
          <li><a href="${pageContext.request.contextPath}/add-students">Add Students</a></li>
      
        </ul>
      </li>
         <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"></span> Users
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${pageContext.request.contextPath}/users">Users List</a></li>
          <li><a href="${pageContext.request.contextPath}/add-user">Add User</a></li>
      
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li> <span style="color:white;">welcome <sec:authentication property="principal.username" /></span> <br/>
      <sec:authorize access="isAuthenticated()">
<c:url var="logoutUrl" value="/logout"/>
<form action="${logoutUrl}" method="post">
  <input type="submit" value="Log out" class="btn-danger"/>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form> 
</sec:authorize> </li>
      <li><sec:authorize access="!isAuthenticated()">
 <a href="${pageContext.request.contextPath}/login" >Login</a> 
 </sec:authorize></li>
    </ul>
  </div>
</nav>