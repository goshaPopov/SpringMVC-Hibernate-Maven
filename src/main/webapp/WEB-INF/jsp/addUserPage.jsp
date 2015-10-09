<%-- 
    Document   : addUserPage
    Created on : Oct 9, 2015, 11:01:23 PM
    Author     : gosha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="saveUrl" value="/user/addUser" />
        <form:form modelAttribute="personAttribute" method="POST" action="${saveUrl}">
	<table>
                <tr>
			<td><form:label path="name">Name:</form:label></td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td><form:label path="surname">Surname:</form:label></td>
			<td><form:input path="surname"/></td>
		</tr>

		<tr>
			<td><form:label path="date_of_birdth">Date of birthday: </form:label></td>
			<td><form:input path="date_of_birdth" type="date" name="calendar"/></td>
		</tr>
		
		<tr>
			<td><form:label path="skills">Skills</form:label></td>
			<td><form:input path="skills"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
        </form:form>
    </body>
</html>
