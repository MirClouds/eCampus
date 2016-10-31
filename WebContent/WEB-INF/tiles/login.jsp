<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<body onload='document.f.username.focus();'>
	<h3>Login with Username and Password - eCampus</h3>
	<c:if test="${param.error != null}">
	<span class="errorLogin">
	Wrong user name and password...
	</span>
	</c:if>
	
	<form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td>Remember Me:</td>
				<td><input type='checkbox' name='_spring_security_remember_me' checked="checked"/></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" class="btn-success"/></td>
			</tr>
			<input name="_csrf" type="hidden"
				value="6e7bdacb-3c3d-49a1-b3aa-3fc9b3023c9a" />
		</table>
	</form>
</body>
 