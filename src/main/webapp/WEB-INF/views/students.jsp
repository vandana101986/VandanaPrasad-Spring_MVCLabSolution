<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
<h1 align="center">Student Debate Registration</h1>

	<!-- ${error} -->

	<table border="1"
		style="border: 1px solid black; border-collapse: collapse;">
		<thead>
			<tr style="background-color: #aec8f2;">
				<th style="padding: 5px;">Student Id</th>
				<th style="padding: 5px;">FirstName</th>
				<th style="padding: 5px;">LastName</th>
				<th style="padding: 5px;">Country</th>
				<th style="padding: 5px;">Action</th>
			</tr>
		</thead>

		
		<tbody>					
					<tr>
      					<td colspan="5" align="center">${error}</td>
      				 </tr>				
			
			       <c:forEach items="${studList}" var="s">
					<tr>					
						<td style="text-align: center;">${s.studId}</td>
						<td>${s.firstName}</td>
						<td>${s.lastName}</td>
						<td>${s.country}</td>
						<td style="line-height: 1.5; text-align: center;">
							<a href="addOrEditRecord?studId=${s.studId}" style="text-decoration: none">Edit Record</a><br> 
							<a href="deleteRecord?studId=${s.studId}" style="text-decoration: none">Delete Record</a>
						</td>
					</tr>
					</c:forEach>	
				
		</tbody>
	</table>
	<br>
	<table>
		<tr>
			<td><a href="addOrEditRecord?studId=0">Add a new student</a></td>
		</tr>
	</table>
	<br>

	<form action="searchByCountry" method="post">
		<table>
			<tr>
				<td>Search Student :</td>
			</tr>
			<tr>
				<td><input type="text" placeholder="Enter a country name"
					name="country" /></td>
				<td colspan="2"><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>
</body>
</html>