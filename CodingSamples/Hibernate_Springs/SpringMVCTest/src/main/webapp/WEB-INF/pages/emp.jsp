<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<sf:form modelAttribute="employee" >
	
		<table border="1">
			
			<tr>
				<td>Id</td>
				<td> <sf:input path="id" id="txtId"/> </td>
			</tr>	
			<tr>
				<td>Name</td>
				<td> <sf:input path="name" id="txtName"/> </td>
			</tr>
			<tr>
				<td>EmailId</td>
				<td> <sf:input path="emailId" id="txtEmail"/> </td>
			</tr>
			<tr>
				<td>designation</td>
				<td> <sf:input path="designation" id="txtDesignation"/> </td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="Save" />
				</td>
			</tr>
			
			
		</table>
		
	</sf:form>
	
	
	<table border="1"> 
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>EmailId</th>
			<th>Designation</th>
		</tr>
		
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td>${emp.emailId }</td>
				<td>${emp.designation }</td>
			</tr>
			
		</c:forEach>
		
	</table>
	
	
</body>
</html>