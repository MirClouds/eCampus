 
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>   
  
      <h1>Edit User</h1>
<sf:form method="post" action="${pageContext.request.contextPath}/added-students" modelAttribute="user" >
<table>
    <sf:hidden path="username" />  

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
<tr>
<td><label>Select Image : </label></td>
<td><input type="file" name="image" value="test.jpg"/></td>
</tr>
<tr><td><input value="Add Student" type="submit" ></td> </tr>
</table>
</sf:form>
