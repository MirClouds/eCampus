 
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>   
  
      <h1>Edit User</h1>
<sf:form method="post" action="${pageContext.request.contextPath}/updateStudents" modelAttribute="student">
<table>

  <tr>
   <td>Person Id:</td>
   <td><input type="text" value="${semester_id}" disabled="true"/>
  </tr>
   <sf:hidden path="student_id" />  
    <sf:hidden path="username" />  
    <sf:hidden path="password" />  
<sf:hidden path="authority" />
<%-- <sf path="semester_id" />
 --%><tr><td>Name</td> <td>    <sf:input path="name" name="name" type="text"/><br/> <sf:errors path="name" cssClass="formError"></sf:errors></td></tr>
<tr><td>Roll Number </td> <td><sf:input type="text"  path="rollnumber" name="rollnumber"/> </td> </tr>
<tr><td>Mobile </td> <td><sf:input type="text" path="mobile"  name="mobile"/> </td> </tr>
<%-- <tr><td>Authority </td> <td>
 <sf:select name="authority" path="authority">
      <option value="ROLE_STUDENT">Student</option>
  <option value="ROLE_TEACHER">Teacher</option>
</sf:select> 
 </td> </tr> --%>

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
<tr><td><input value="Update user" type="submit" class="btn btn-success" ></td> </tr>
</table>
</sf:form>
